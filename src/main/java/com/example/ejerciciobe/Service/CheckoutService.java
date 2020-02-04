package com.example.ejerciciobe.Service;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Entity.Product;
import com.example.ejerciciobe.Entity.Status;
import com.example.ejerciciobe.Utils.CartStatusChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private CartService cartService;
    private ProductService productService;

    @Autowired
    public CheckoutService(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    public void checkoutCart(Cart cart) {
        CartStatusChecker.statusReady(cart);
        cart.setStatus(Status.PROCESSED);
        for (CartProduct cartProduct: cart.getProducts()) {
            Product product = cartProduct.getProduct();
            if (!cartProduct.isStockAvailable()) {
                cart.setStatus(Status.FAILED);
                break;
            }
            product.subtractFromStock(cartProduct.getQuantity());
            productService.save(product);
        }
        cartService.save(cart);
    }
}
