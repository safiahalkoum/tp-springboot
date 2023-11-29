package com.crea.backend.microservicespringboot.model;

import jakarta.persistence.*;

@Entity
public class UserProductFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public UserData getUser() {
        return user;
    }
}
