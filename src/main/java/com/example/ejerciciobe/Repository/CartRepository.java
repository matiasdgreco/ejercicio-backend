package com.example.ejerciciobe.Repository;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findAllByStatusEquals(Status status);
}
