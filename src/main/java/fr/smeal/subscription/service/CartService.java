package fr.smeal.subscription.service;

import fr.smeal.subscription.entity.CartEntity;
import fr.smeal.subscription.entity.CartProductEntity;
import fr.smeal.subscription.model.Cart;

import java.util.List;

public interface CartService {
    Cart getCart(Integer cartId);
    CartEntity getCartEntity(Integer cartId);
    void subscriptCart(Integer cartId);
    void unsubscriptCart(Integer cartId);
    List<CartProductEntity> getCartProduct(Integer cartId);

}
