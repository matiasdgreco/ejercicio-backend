package com.example.ejerciciobe.Entity;

public class CartProductRequest {
    private Long id;
    private Integer quantity;

    public CartProductRequest(Long product, Integer quantity) {
        this.id = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
