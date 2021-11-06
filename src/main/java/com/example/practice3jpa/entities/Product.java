package com.example.practice3jpa.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "product")

@NamedQueries({
        @NamedQuery(name=Product.FIND_ALL, query="select s from Product s"),
        @NamedQuery(name=Product.FIND_PRODUCT_BY_ID,
                query="select distinct s from Product s " +
                        "left join fetch s.clients a " +
                        "where s.id = :id"),
        @NamedQuery(name=Product.FIND_ALL_WITH_CLIENT,
                query="select distinct s from Product s " +
                        "left join fetch s.clients a ")
})

@SqlResultSetMapping(
        name="productResult",
        entities=@EntityResult(entityClass=Product.class)
)

public class Product implements Serializable {
    public static final String FIND_ALL = "Product.findAll";
    public static final String FIND_PRODUCT_BY_ID = "Product.findProductById";
    public static final String FIND_ALL_WITH_CLIENT = "Product.findAllWithClient";


    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_PRICE")
    private int productPrice;

    @Column(name = "PRODUCT_QUANTITY")
    private int productQuantity;

    @OneToMany(mappedBy = "product", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Client> clients = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}

