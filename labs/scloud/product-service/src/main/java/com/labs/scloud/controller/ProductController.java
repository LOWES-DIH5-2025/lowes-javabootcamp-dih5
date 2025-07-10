package com.labs.scloud.controller;

import com.labs.scloud.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/")
public class ProductController {
    // implement create product and get all products

    Map<Integer, Product> products = new HashMap<>();

    // populate sample data
    public  ProductController() {
         products.put(1, Product.builder().id(1).name("Laptop").description("High-performance laptop for work and gaming").price(1000.0).build());
         products.put(2, Product.builder().id(2).name("Smartphone").description("Latest model smartphone with advanced features").price(500.0).build());
         products.put(3, Product.builder().id(3).name("Tablet").description("Lightweight tablet suitable for reading and browsing").price(300.0).build());
    }

    @GetMapping("/")
    public String welcome(HttpServletRequest request) {
        return "Welcome to Product Service! - " + request.getRequestURL().toString();
    }

    @PostMapping("/products")
    public Product createProduct(Product product) {
        // Logic to create a product
        products.put(product.getId(), product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        // Logic to retrieve all products
        return new ArrayList<>(products.values());
    }

}
