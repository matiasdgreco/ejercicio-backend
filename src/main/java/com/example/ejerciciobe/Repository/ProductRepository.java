package com.example.ejerciciobe.Repository;

import com.example.ejerciciobe.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
