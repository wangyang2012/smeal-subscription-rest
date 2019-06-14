package fr.smeal.subscription.entity;

import javax.persistence.*;

@Entity
@Table(name="ps_cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cart")
    private Integer id;

    @Column(name="id_customer")
    private Integer idCustomer;

    @Column(name="id_shop")
    private Integer idShop;

    @Column(name="id_carrier")
    private Integer idCarrier;

    @Column(name="id_lang")
    private Integer idLang;

    @Column(name="id_address_delivery")
    private Integer idAddressDelivery;

    @Column(name="id_address_invoice")
    private Integer idAddressInvoice;

    @Column(name="id_currency")
    private Integer idCurrency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(Integer idCarrier) {
        this.idCarrier = idCarrier;
    }

    public Integer getIdLang() {
        return idLang;
    }

    public void setIdLang(Integer idLang) {
        this.idLang = idLang;
    }

    public Integer getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(Integer idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public Integer getIdAddressInvoice() {
        return idAddressInvoice;
    }

    public void setIdAddressInvoice(Integer idAddressInvoice) {
        this.idAddressInvoice = idAddressInvoice;
    }

    public Integer getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
    }
}
