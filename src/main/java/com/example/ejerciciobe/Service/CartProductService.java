package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Repository.CartProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartProductService {
    private CartProductRepository repository;

    public CartProductService(CartProductRepository repository) {
        this.repository = repository;
    }

    public void save(CartProduct cartProduct) {
        repository.save(cartProduct);
    }
}
