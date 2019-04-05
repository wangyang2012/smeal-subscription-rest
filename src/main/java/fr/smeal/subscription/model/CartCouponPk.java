package fr.smeal.subscription.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartCouponPk implements Serializable {
    @Column(name="id_cart")
    private Integer idCart;

    @Column(name="id_cart_rule")
    private Integer idCoupon;

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Integer getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(Integer idCoupon) {
        this.idCoupon = idCoupon;
    }
}
