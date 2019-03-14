package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.model.Cart;
import fr.smeal.subscription.model.Product;
import fr.smeal.subscription.service.CartService;
import fr.smeal.subscription.util.NetworkUtil;
import fr.smeal.subscription.util.XmlUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Override
    public Cart getCart(Integer cartId) {

        String url = "https://www.smeal.fr/api/carts/" + cartId + "?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
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
                if (productId != null) {
                    Product product = getProduct(productId);
                    totalTtc = totalTtc.add(product.getPriceTtc());
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

    public Product getProduct(String productId) {

        String url = "https://www.smeal.fr/api/products/" + productId + "?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
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
            product.setPriceTtc(product.getPriceHt().multiply(tax));
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
}
