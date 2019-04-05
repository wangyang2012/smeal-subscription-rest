package fr.smeal.subscription.model;


import javax.persistence.*;

@Entity
@Table(name="ps_cart_cart_rule")
public class CartCoupon {
    @EmbeddedId
    private CartCouponPk id;

    public CartCouponPk getId() {
        return id;
    }

    public void setId(CartCouponPk id) {
        this.id = id;
    }
}
