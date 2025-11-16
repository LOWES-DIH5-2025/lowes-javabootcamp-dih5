package com.labs.sboot.webflux.spring_boot_webflux_demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
  Flux<Product> getAllProducts();

  Mono<Product> getProductById(String id);

  Mono<Product> createProduct(Product product);

  Mono<Product> updateProduct(String id, Product product);

  Mono<Void> deleteProduct(String id);
}