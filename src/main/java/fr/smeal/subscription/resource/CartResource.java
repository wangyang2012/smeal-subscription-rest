package fr.smeal.subscription.resource;

import fr.smeal.subscription.model.Cart;
import fr.smeal.subscription.model.KeyValue;
import fr.smeal.subscription.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartResource {

    @Autowired
    private CartService cartService;

    @GetMapping(value="/{cartId}")
    public Cart getCart(@PathVariable Integer cartId) {
        Cart cart = cartService.getCart(cartId);
        return cart;
    }
}
