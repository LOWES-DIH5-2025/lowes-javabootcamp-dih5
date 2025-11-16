package com.labs.sboot.webflux;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerWebClient {
    private final WebClient webClient;

    public CustomerWebClient(String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<Customer> createCustomer(Customer customer) {
        return webClient.post()
                .uri("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customer))
                .retrieve()
                .bodyToMono(Customer.class);
    }

    public Flux<Customer> getAllCustomers() {
        return webClient.get()
                .uri("/api/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    public Mono<Customer> getCustomerById(Long id) {
        return webClient.get()
                .uri("/api/customers/{id}", id)
                .retrieve()
                .bodyToMono(Customer.class);
    }

    public Mono<Customer> updateCustomer(Long id, Customer customer) {
        return webClient.put()
                .uri("/api/customers/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customer))
                .retrieve()
                .bodyToMono(Customer.class);
    }

    public Mono<Void> deleteCustomer(Long id) {
        return webClient.delete()
                .uri("/api/customers/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
