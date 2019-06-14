package fr.smeal.subscription.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ps_product_lang")
public class ProductLangueEntity {
    @EmbeddedId
    private ProductLangueEntityPk id;

    @Column(name="name")
    private String name;

    public ProductLangueEntityPk getId() {
        return id;
    }

    public void setId(ProductLangueEntityPk id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
