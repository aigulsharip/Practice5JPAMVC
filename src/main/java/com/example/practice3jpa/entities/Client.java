package com.example.practice3jpa.entities;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "client")

@SqlResultSetMapping(
        name="clientResult",
        entities=@EntityResult(entityClass=Client.class)
)


public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


    @Column(name = "CLIENT_EMAIL")
    private String clientEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
