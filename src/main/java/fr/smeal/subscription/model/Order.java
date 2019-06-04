package fr.smeal.subscription.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ps_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    @Column(name="reference")
    private String reference;

    @Column(name="id_carrier")
    private Integer idCarrier;

    @Column(name="id_lang")
    private Integer idLang;

    @Column(name="id_customer")
    private Integer idCustomer;

    @Column(name="id_cart")
    private Integer idCart;

    @Column(name="id_currency")
    private Integer idCurrency;

    @Column(name="id_address_delivery")
    private Integer idAddressDelivery;

    @Column(name="id_address_invoice")
    private Integer idAddressInvoice;

    @Column(name="current_state")
    private Integer currentState;

    @Column(name="payment")
    private String paiyment;

    @Column(name="conversion_rate")
    private BigDecimal conversionRate;

    @Column(name="recyclable")
    private Boolean recyclable;

    @Column(name="gift")
    private Boolean gift;

    @Column(name="total_paid")
    private BigDecimal totalPaid;

    @Column(name="total_paid_tax_incl")
    private BigDecimal totalPaidTaxIncluded;

    @Column(name="invoice_date")
    private Date invoiceDate;

    @Column(name="delivery_date")
    private Date deliveryDate;

    @Column(name="date_add")
    private Date dateAdd;

    @Column(name="date_upd")
    private Date dateUpdate;

    @Column(name="valid")
    private Boolean valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Integer getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Integer idCurrency) {
        this.idCurrency = idCurrency;
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

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public String getPaiyment() {
        return paiyment;
    }

    public void setPaiyment(String paiyment) {
        this.paiyment = paiyment;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Boolean getRecyclable() {
        return recyclable;
    }

    public void setRecyclable(Boolean recyclable) {
        this.recyclable = recyclable;
    }

    public Boolean getGift() {
        return gift;
    }

    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public BigDecimal getTotalPaidTaxIncluded() {
        return totalPaidTaxIncluded;
    }

    public void setTotalPaidTaxIncluded(BigDecimal totalPaidTaxIncluded) {
        this.totalPaidTaxIncluded = totalPaidTaxIncluded;
    }
}
