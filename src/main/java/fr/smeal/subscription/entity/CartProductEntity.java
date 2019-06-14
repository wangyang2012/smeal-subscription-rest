package fr.smeal.subscription.entity;

import fr.smeal.subscription.model.CartCouponPk;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ps_cart_product")
public class CartProductEntity {

    @EmbeddedId
    private CartProductPk id;

    @Column(name="id_address_delivery")
    private Integer idAddressDelivery;

    @Column(name="id_shop")
    private Integer idShop;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="id_product_attribute")
    private Integer idProductAttribute;

    @Column(name="id_customization")
    private Integer idCustomization;

    @Column(name="date_add")
    private Date dateAdd;

    public CartProductPk getId() {
        return id;
    }

    public void setId(CartProductPk id) {
        this.id = id;
    }

    public Integer getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(Integer idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(Integer idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public Integer getIdCustomization() {
        return idCustomization;
    }

    public void setIdCustomization(Integer idCustomization) {
        this.idCustomization = idCustomization;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }
}
