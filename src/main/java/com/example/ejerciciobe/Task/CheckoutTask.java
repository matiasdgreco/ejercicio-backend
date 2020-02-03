package com.example.ejerciciobe.Task;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.SchedulingTask.CheckoutScheduledTask;
import com.example.ejerciciobe.Service.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class CheckoutTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutScheduledTask.class);
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutTask(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @Async
    public void checkoutCart(Cart cart) {
        checkoutService.checkoutCart(cart);
        LOGGER.info("Cart " + cart.getId() + " status: " + cart.getStatus());
    }
}
