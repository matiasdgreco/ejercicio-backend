package com.example.ejerciciobe.Controller;

import com.example.ejerciciobe.Entity.Product;
import com.example.ejerciciobe.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        service.save(product);
        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable Long id) {
        return service.findById(id);
    }
}
