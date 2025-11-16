package com.labs.sboot.webflux.spring_boot_webflux_demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
}