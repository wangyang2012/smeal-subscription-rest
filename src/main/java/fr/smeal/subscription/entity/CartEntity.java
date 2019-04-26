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
}
