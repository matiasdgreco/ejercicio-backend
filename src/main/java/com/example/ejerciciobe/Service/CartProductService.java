package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Entity.CartProductRequest;
import com.example.ejerciciobe.Entity.Product;
import com.example.ejerciciobe.Repository.CartProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {
    private CartProductRepository repository;
    private ProductService productService;

    public CartProductService(CartProductRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public void save(CartProduct cartProduct) {
        repository.save(cartProduct);
    }

    public void addCartProduct(Cart cart, CartProductRequest cartProductRequest) {
        Optional<Product> optionalProduct = productService.findById(cartProductRequest.getId());
        Product product = optionalProduct.get();

        CartProduct cartProduct = new CartProduct(cart, product, cartProductRequest.getQuantity(), product.getUnit_price());
        save(cartProduct);
    }
}
