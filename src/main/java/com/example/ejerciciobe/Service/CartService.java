package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.*;
import com.example.ejerciciobe.Exception.BadRequestException;
import com.example.ejerciciobe.Exception.EntityNotFoundException;
import com.example.ejerciciobe.Repository.CartRepository;
import com.example.ejerciciobe.Utils.CartStatusChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        CartStatusChecker.statusNew(cart);
        Optional<Product> optionalProduct = productService.findById(cartProductRequest.getId());
        if (!optionalProduct.isPresent()) {
            throw new EntityNotFoundException();
        }
        Product product = optionalProduct.get();

        CartProduct cartProduct = new CartProduct(cart, product, cartProductRequest.getQuantity());
        if (!cartProduct.isStockAvailable()) {
            throw new BadRequestException("Sorry, the requested stock is not available");
        }

        cartProductService.save(cartProduct);

        cart.addToTotal(cartProduct.getSubtotal());
        repository.save(cart);
    }

    public void checkout(Long id) {
        Optional<Cart> optionalCart = findById(id);
        if (!optionalCart.isPresent()) {
            throw new EntityNotFoundException();
        }
        Cart cart = optionalCart.get();
        CartStatusChecker.statusNew(cart);
        cart.setStatus(Status.READY);
        save(cart);
    }

    public void removeProduct(Long cartId, Long productId) {
        Optional<CartProduct> optionalCartProduct = cartProductService.findByCartIdAndProductId(cartId, productId);
        if (!optionalCartProduct.isPresent()) {
            throw new EntityNotFoundException();
        }
        CartProduct cartProduct = optionalCartProduct.get();

        Cart cart = cartProduct.getCart();
        cart.subtractFromTotal(cartProduct.getSubtotal());

        cartProductService.delete(cartProduct);
        save(cart);
    }

    public List<Cart> findAllWithStatusReady() {
        return repository.findAllByStatusEquals(Status.READY);
    }
}
