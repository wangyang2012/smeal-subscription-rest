package fr.smeal.subscription.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ps_order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private Integer id;

    @Column(name="id_order")
    private Integer idOrder;

    @Column(name="id_order_invoice")
    private Integer idOrderInvoice;

    @Column(name="id_shop")
    private Integer idShop;

    @Column(name="product_id")
    private Integer idProduct;

    @Column(name="product_attribute_id")
    private Integer idProductAttribute;

    @Column(name="id_customization")
    private Integer idCustomization;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_quantity")
    private Integer productQuantity;

    @Column(name="product_price")
    private BigDecimal productPrice;

    @Column(name="product_reference")
    private String productReference;

    @Column(name="total_price_tax_incl")
    private BigDecimal totalPriceTaxIncl;

    @Column(name="total_price_tax_excl")
    private BigDecimal totalPriceTaxExcl;


    @Column(name="unit_price_tax_incl")
    private BigDecimal unitPriceTaxIncl;

    @Column(name="unit_price_tax_excl")
    private BigDecimal unitPriceTaxExcl;

    @Column(name="original_product_price")
    private BigDecimal originalProductPrice;

    @Column(name="product_weight")
    private BigDecimal productWeight;

    @Column(name="tax_name")
    private String taxName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(Integer idOrderInvoice) {
        this.idOrderInvoice = idOrderInvoice;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public BigDecimal getTotalPriceTaxIncl() {
        return totalPriceTaxIncl;
    }

    public void setTotalPriceTaxIncl(BigDecimal totalPriceTaxIncl) {
        this.totalPriceTaxIncl = totalPriceTaxIncl;
    }

    public BigDecimal getTotalPriceTaxExcl() {
        return totalPriceTaxExcl;
    }

    public void setTotalPriceTaxExcl(BigDecimal totalPriceTaxExcl) {
        this.totalPriceTaxExcl = totalPriceTaxExcl;
    }

    public BigDecimal getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(BigDecimal unitPriceTaxIncl) {
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }

    public BigDecimal getUnitPriceTaxExcl() {
        return unitPriceTaxExcl;
    }

    public void setUnitPriceTaxExcl(BigDecimal unitPriceTaxExcl) {
        this.unitPriceTaxExcl = unitPriceTaxExcl;
    }

    public BigDecimal getOriginalProductPrice() {
        return originalProductPrice;
    }

    public void setOriginalProductPrice(BigDecimal originalProductPrice) {
        this.originalProductPrice = originalProductPrice;
    }

    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }
}
