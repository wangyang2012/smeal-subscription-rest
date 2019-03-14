package fr.smeal.subscription.service;

import fr.smeal.subscription.model.Cart;

public interface CartService {
    Cart getCart(Integer cartId);
}
