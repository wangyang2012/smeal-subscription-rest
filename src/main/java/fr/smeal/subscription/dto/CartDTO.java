package fr.smeal.subscription.dto;

import java.util.List;

public class CartDTO {
    private Integer id;
    private Long totalTtc;
    private List<ProductDTO> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(Long totalTtc) {
        this.totalTtc = totalTtc;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
