package com.example.ejerciciobe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Double unit_price;
    private Integer stock;

    protected Product() {
    }

    public Product(String description, Double unit_price, Integer stock) {
        this.description = description;
        this.unit_price = unit_price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void substractFromStock(Integer quantity) {
        stock -= quantity;
    }
}
