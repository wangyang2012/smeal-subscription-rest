package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.model.Cart;
import fr.smeal.subscription.service.CartService;
import fr.smeal.subscription.util.NetworkUtil;
import fr.smeal.subscription.util.XmlUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

            return cart;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
