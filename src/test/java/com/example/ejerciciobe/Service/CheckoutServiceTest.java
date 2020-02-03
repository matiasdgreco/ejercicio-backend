package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class CheckoutServiceTest {
    CheckoutService checkoutService;
    @MockBean
    CartService cartService;
    @MockBean
    ProductService productService;
    private Cart cart;
    private Product product;

    @BeforeEach
    public void setUp() {
        checkoutService = new CheckoutService(cartService, productService);
        cart = new Cart(new CartRequest("Matias Greco", "matiasdgreco@gmail.com"));
        product = new Product("Test product", (double) 100, 5);
    }

    @Test
    public void testCartProcessed() {
        CartProduct cartProduct = new CartProduct(cart, product, 1);
        cart.getProducts().add(cartProduct);
        checkoutService.checkoutCart(cart);
        assertEquals(Status.PROCESSED, cart.getStatus());
        assertEquals(4, product.getStock());
    }

    @Test
    public void testCartFailed() {
        CartProduct cartProduct = new CartProduct(cart, product, 6);
        cart.getProducts().add(cartProduct);
        checkoutService.checkoutCart(cart);
        assertEquals(Status.FAILED, cart.getStatus());
        assertEquals(5, product.getStock());
    }
}