package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.Product;
import com.example.ejerciciobe.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
