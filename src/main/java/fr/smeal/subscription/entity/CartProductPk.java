package fr.smeal.subscription.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartProductPk implements Serializable {
    @Column(name="id_cart")
    private Integer idCart;

    @Column(name="id_product")
    private Integer idProduct;

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
