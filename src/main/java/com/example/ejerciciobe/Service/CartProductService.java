package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Repository.CartProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {
    private CartProductRepository repository;

    public CartProductService(CartProductRepository repository) {
        this.repository = repository;
    }

    public void save(CartProduct cartProduct) {
        repository.save(cartProduct);
    }

    public Optional<CartProduct> findByCartIdAndProductId(Long cartId, Long productId) {
        return repository.findByCartIdAndProductId(cartId, productId);
    }

    public void delete(CartProduct cartProduct) {
        repository.delete(cartProduct);
    }
}
