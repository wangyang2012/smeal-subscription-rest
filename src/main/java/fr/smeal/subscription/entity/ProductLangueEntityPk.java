package fr.smeal.subscription.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class ProductLangueEntityPk implements Serializable {
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "id_shop")
    private Integer idShop;

    @Column(name = "id_lang")
    private Integer idLang;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getIdLang() {
        return idLang;
    }

    public void setIdLang(Integer idLang) {
        this.idLang = idLang;
    }
}
