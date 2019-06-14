package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.dao.CartCouponRepository;
import fr.smeal.subscription.dao.CartProductRepository;
import fr.smeal.subscription.dao.CartRepository;
import fr.smeal.subscription.entity.CartEntity;
import fr.smeal.subscription.entity.CartProductEntity;
import fr.smeal.subscription.model.Cart;
import fr.smeal.subscription.model.CartCoupon;
import fr.smeal.subscription.model.CartCouponPk;
import fr.smeal.subscription.model.Product;
import fr.smeal.subscription.service.CartService;
import fr.smeal.subscription.util.NetworkUtil;
import fr.smeal.subscription.util.ParameterUtil;
import fr.smeal.subscription.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartCouponRepository cartCouponRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public Cart getCart(Integer cartId) {

        String url = ParameterUtil.getSmealApiUrl("/carts/" + cartId);
        try {
            String cartStr = NetworkUtil.sendGet(url);
            cartStr = cartStr.substring(cartStr.indexOf("<cart>"));
            cartStr = cartStr.replaceAll("</prestashop>", "");
            cartStr = cartStr.replaceAll("<!\\[CDATA\\[", "");
            cartStr = cartStr.replaceAll("]]>", "");

            Cart cart = new Cart();
            cart.setId(XmlUtil.getIntValue(cartStr, "id"));
            cart.setIdCustomer(XmlUtil.getIntValue(cartStr, "id_customer"));
            List<String> productsStr = XmlUtil.getMultiValues(cartStr, "cart_row");
            BigDecimal totalTtc = new BigDecimal(0);
            for (String productStr : productsStr) {
                String productId = XmlUtil.getValue(productStr, "id_product");
                BigDecimal number = XmlUtil.getBigDecimalValue(productStr, "quantity");
                if (productId != null) {
                    Product product = getProduct(productId);
                    totalTtc = totalTtc.add(product.getPriceTtc().multiply(number));
                    cart.getProducts().add(product);
                }
            }
            cart.setTotalTtc(totalTtc);
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Change subscription from 0 to 1
     *  <subscription>
            <![CDATA[ 0 ]]>
        </subscription>
     * @param cartId
     */
    @Override
    public void subscriptCart(Integer cartId) {
        String url = ParameterUtil.getSmealApiUrl("/carts/" + cartId);
        try {
            String cartStr = NetworkUtil.sendGet(url);
            cartStr = cartStr.substring(cartStr.indexOf("<cart>"));
            cartStr = cartStr.replaceAll("</prestashop>", "");
            cartStr = cartStr.replaceAll("<!\\[CDATA\\[", "");
            cartStr = cartStr.replaceAll("]]>", "");

            cartStr = cartStr.replaceAll("<subscription>0</subscription>", "<subscription>1</subscription>");
            this.addCouponToCart(cartId, 1);

            NetworkUtil.sendPut(url, "<prestashop>"+cartStr+"</prestashop>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addCouponToCart(Integer cartId, Integer couponId) {
        CartCoupon cartCoupon = new CartCoupon();
        CartCouponPk id = new CartCouponPk();
        id.setIdCart(cartId);
        id.setIdCoupon(couponId);
        cartCoupon.setId(id);
        cartCouponRepository.save(cartCoupon);
    }

    /**
     * Change subscription from 1 to 0
     *  <subscription>
     <![CDATA[ 0 ]]>
     </subscription>
     * @param cartId
     */
    @Override
    public void unsubscriptCart(Integer cartId) {

        String url = ParameterUtil.getSmealApiUrl("/carts/" + cartId);
        try {
            String cartStr = NetworkUtil.sendGet(url);
            cartStr = cartStr.substring(cartStr.indexOf("<cart>"));
            cartStr = cartStr.replaceAll("</prestashop>", "");
            cartStr = cartStr.replaceAll("<!\\[CDATA\\[", "");
            cartStr = cartStr.replaceAll("]]>", "");

            cartStr = cartStr.replaceAll("<subscription>1</subscription>", "<subscription>0</subscription>");

            NetworkUtil.sendPut(url, cartStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(String productId) {

        String url = ParameterUtil.getSmealApiUrl("/products/" + productId);
        try {
            String productStr = NetworkUtil.sendGet(url);
            productStr = productStr.substring(productStr.indexOf("<product>"));
            productStr = productStr.replaceAll("</prestashop>", "");
            productStr = productStr.replaceAll("<!\\[CDATA\\[", "");
            productStr = productStr.replaceAll("]]>", "");

            Product product = new Product();
            product.setId(XmlUtil.getIntValue(productStr, "id"));
            product.setReference(XmlUtil.getValue(productStr, "reference"));
            product.setPriceHt(XmlUtil.getBigDecimalValue(productStr, "price"));
            BigDecimal tax = getTax(XmlUtil.getValue(productStr, "id_tax_rules_group"));
            BigDecimal prixHt = product.getPriceHt();
            BigDecimal prixTtc = prixHt.add(prixHt.multiply(tax).divide(new BigDecimal(100)));
            product.setPriceTtc(prixTtc);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public BigDecimal getTax(String taxRulesGroupId) {
        // TODO: tax_rule_group => tax_rules + country => tax_id => tax
        return new BigDecimal(5.5f);
    }

    @Override
    public CartEntity getCartEntity(Integer cartId) {
        return cartRepository.getById(cartId);
    }

    @Override
    public List<CartProductEntity> getCartProduct(Integer cartId) {
        return cartProductRepository.findById_IdCart(cartId);
    }
}
