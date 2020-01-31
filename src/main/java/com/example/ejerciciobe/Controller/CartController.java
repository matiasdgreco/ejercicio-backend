package com.example.ejerciciobe.Controller;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.CartRequest;
import com.example.ejerciciobe.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cart saveCart(@RequestBody CartRequest cartRequest) {
        return service.save(cartRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> getProductById(@PathVariable Long id) {
        return service.findById(id);
    }
}
