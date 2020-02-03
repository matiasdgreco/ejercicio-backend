package com.example.ejerciciobe.SchedulingTask;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Service.CartService;
import com.example.ejerciciobe.Task.CheckoutTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckoutScheduledTask {
    private CartService cartService;
    private CheckoutTask checkoutTask;


    @Autowired
    public CheckoutScheduledTask(CartService cartService, CheckoutTask checkoutTask) {
        this.cartService = cartService;
        this.checkoutTask = checkoutTask;
    }

    @Scheduled(fixedRate = 60000)
    public void checkoutCarts() {
        List<Cart> carts = cartService.findAllWithStatusReady();
        for (Cart cart: carts) {
            checkoutTask.checkoutCart(cart);
        }
    }
}
