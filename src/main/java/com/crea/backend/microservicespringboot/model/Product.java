package com.crea.backend.microservicespringboot.model;


import jakarta.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String category;
    private Integer price;
    @Column(name = "PURCHASEPRICE")
    private Integer purchasePrice;

    // constructeur pour nos tests

    public Product(Integer id, String name, String category, Integer price, Integer purchasePrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.purchasePrice = purchasePrice;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
    }
}
