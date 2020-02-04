package com.example.ejerciciobe.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Cart cart;
    @ManyToOne
    @JoinColumn
    private Product product;
    private Integer quantity;
    private Double unit_price;

    protected CartProduct() {
    }

    public CartProduct(Cart cart, Product product, Integer quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.unit_price = product.getUnit_price();
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    @JsonIgnore
    public Double getSubtotal() {
        return this.unit_price * this.quantity;
    }

    @JsonIgnore
    public Boolean isStockAvailable() {
        return product.getStock() >= quantity;
    }
}
