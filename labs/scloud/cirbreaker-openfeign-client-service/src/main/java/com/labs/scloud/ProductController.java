package com.labs.scloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

@Autowired
private ProductService productService;

@Autowired
private CircuitBreakerFactory circuitBreakerFactory;

@GetMapping("/")
public String welcome() {
    return circuitBreakerFactory.create("cb-openfeign-product-service-client")
        .run(() -> productService.welcome(), throwable -> "Service unavailable");
}

@GetMapping("/fetch-products")
public List<Product> getAllProducts() {
    return circuitBreakerFactory.create("cb-openfeign-product-service-client")
        .run(() -> productService.getAllProducts(), throwable -> List.of());
}

}
