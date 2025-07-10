package com.labs.scloud;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductService {

    @GetMapping("/")
    public String welcome();

    @GetMapping("/products")
    public List<Product> getAllProducts();

    @PostMapping("/products")
    public Product createProduct(Product product);
}
