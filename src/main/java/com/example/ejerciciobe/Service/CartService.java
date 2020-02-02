package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Entity.CartProductRequest;
import com.example.ejerciciobe.Entity.CartRequest;
import com.example.ejerciciobe.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    private CartRepository repository;
    private CartProductService cartProductService;

    @Autowired
    public CartService(CartRepository repository, CartProductService cartProductService) {
        this.repository = repository;
        this.cartProductService = cartProductService;
    }

    public void save(Cart cart) {
        repository.save(cart);
    }

    public Cart save(CartRequest cartRequest) {
        Cart cart = new Cart(cartRequest);
        save(cart);
        return cart;
    }

    public Optional<Cart> findById(Long id) {
        return repository.findById(id);
    }

    public void addProduct(Cart cart, CartProductRequest cartProductRequest) {
        cartProductService.addCartProduct(cart, cartProductRequest);
    }
}
