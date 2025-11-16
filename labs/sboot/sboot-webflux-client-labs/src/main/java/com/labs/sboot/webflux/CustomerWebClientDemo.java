package com.labs.sboot.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerWebClientDemo {
    public static void main(String[] args) {
        CustomerWebClient client = new CustomerWebClient("http://localhost:8080");

        // CREATE
        Customer newCustomer = new Customer(null, "John Doe", "john.doe@example.com");
        Mono<Customer> created = client.createCustomer(newCustomer);
        created.doOnNext(c -> System.out.println("Created: " + c.getId() + ", " + c.getName() + ", " + c.getEmail()))
                .block();

        // READ ALL
        Flux<Customer> customers = client.getAllCustomers();
        customers.doOnNext(c -> System.out.println("Customer: " + c.getId() + ", " + c.getName() + ", " + c.getEmail()))
                .collectList().block();

        // UPDATE (Assume id=1 for demo)
        Customer updatedCustomer = new Customer(1L, "Jane Doe", "jane.doe@example.com");
        Mono<Customer> updated = client.updateCustomer(1L, updatedCustomer);
        updated.doOnNext(c -> System.out.println("Updated: " + c.getId() + ", " + c.getName() + ", " + c.getEmail()))
                .block();

        // DELETE (Assume id=1 for demo)
        Mono<Void> deleted = client.deleteCustomer(1L);
        deleted.doOnSuccess(v -> System.out.println("Deleted customer with id 1"))
                .block();
    }
}
