package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.*;
import com.example.ejerciciobe.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    private CartRepository repository;
    private CartProductService cartProductService;
    private ProductService productService;

    @Autowired
    public CartService(CartRepository repository, CartProductService cartProductService, ProductService productService) {
        this.repository = repository;
        this.cartProductService = cartProductService;
        this.productService = productService;
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
        Optional<Product> optionalProduct = productService.findById(cartProductRequest.getId());
        Product product = optionalProduct.get();

        CartProduct cartProduct = new CartProduct(cart, product, cartProductRequest.getQuantity(), product.getUnit_price());
        cartProductService.save(cartProduct);

        cart.addToTotal(product.getUnit_price() * cartProductRequest.getQuantity());
        repository.save(cart);
    }

    public void checkout(Long id) {
        Optional<Cart> optionalCart = findById(id);
        Cart cart = optionalCart.get();
        cart.setStatus(Status.READY);
        save(cart);
    }
}
