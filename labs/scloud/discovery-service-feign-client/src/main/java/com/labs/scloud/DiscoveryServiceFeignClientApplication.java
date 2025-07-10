package com.labs.scloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class DiscoveryServiceFeignClientApplication implements CommandLineRunner {

	@Autowired
	ProductService service;

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceFeignClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Product> products = service.getAllProducts();
		log.info("No of products: {}", products.size());
		for(Product product : products) {
			log.info("Product: {}", product);
		}

		for (int i = 0; i < 5; i++) {
			log.info("Response: {}", service.welcome());
		}
	}
}
