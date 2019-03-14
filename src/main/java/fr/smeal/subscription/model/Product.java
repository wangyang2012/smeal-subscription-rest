package fr.smeal.subscription.model;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String reference;
    private BigDecimal priceHt;
    private BigDecimal priceTtc;
    private Integer taxRule;

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

    public BigDecimal getPriceHt() {
        return priceHt;
    }

    public void setPriceHt(BigDecimal priceHt) {
        this.priceHt = priceHt;
    }

    public Integer getTaxRule() {
        return taxRule;
    }

    public void setTaxRule(Integer taxRule) {
        this.taxRule = taxRule;
    }

    public BigDecimal getPriceTtc() {
        return priceTtc;
    }

    public void setPriceTtc(BigDecimal priceTtc) {
        this.priceTtc = priceTtc;
    }
}
