package com.example.ejerciciobe.Repository;

import com.example.ejerciciobe.Entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    Optional<CartProduct> findByCartIdAndProductId(Long cartId, Long productId);
}
