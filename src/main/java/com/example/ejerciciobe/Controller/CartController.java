package com.example.ejerciciobe.Controller;

import com.example.ejerciciobe.Entity.Cart;
import com.example.ejerciciobe.Entity.CartProduct;
import com.example.ejerciciobe.Entity.CartProductRequest;
import com.example.ejerciciobe.Entity.CartRequest;
import com.example.ejerciciobe.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
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
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.POST)
    public ResponseEntity addProduct(@PathVariable Long id, @RequestBody CartProductRequest cartProductRequest) {
        Optional<Cart> optionalCart = service.findById(id);
        service.addProduct(optionalCart.get(), cartProductRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
    public List<CartProduct> getCartProducts(@PathVariable Long id) {
        return service.findById(id).get().getCartProducts();
    }
}
