package com.labs.scloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@Service
class ProductServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public String getProducts() {
        // 'product-service' is the service name registered with Eureka
        return restTemplate.getForObject("http://product-service", String.class);
    }
}

@RestController
class ProductController {
    @Autowired
    private ProductServiceClient productServiceClient;

    @GetMapping("/fetch-products")
    public String fetchProducts() {
        return productServiceClient.getProducts();
    }
}

