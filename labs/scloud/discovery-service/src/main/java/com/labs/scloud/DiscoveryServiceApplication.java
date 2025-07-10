package com.labs.scloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryServiceApplication implements CommandLineRunner {

	@Autowired
	DiscoveryClient discoveryClient;

//	@Bean
//	@LoadBalanced
//	public RestTemplate restClient() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ServiceInstance> services = discoveryClient.getInstances("product-service");

		log.info("No of instances: {}", services.size());

//		String baseUrl = "http://localhost:9090";

		String baseUrl = services.get(0).getUri().toString();
		RestClient client = RestClient.create(baseUrl);


//		services.forEach( service -> {
//			String baseUrl = service.getUri().toString();
//			log.info("Base URL: {}", baseUrl);
//			RestClient client = RestClient.create(baseUrl);

			for(int i = 0; i < 5; i++)
				{
					Collection<Object> products = client.get()
							.uri("/products")
							.retrieve()
							.body(new ParameterizedTypeReference<Collection<Object>>() {
							});

					products.forEach(product -> {
						log.info("Product: {}", product);
					});

//					String path = restClient().get()
//							.uri("/")
//							.retrieve()
//							.body(String.class);

//					String response = restClient().getForObject("http://product-service", String.class);
//
//					log.info("Response: {}", response);
				}

//		});
	}
}
