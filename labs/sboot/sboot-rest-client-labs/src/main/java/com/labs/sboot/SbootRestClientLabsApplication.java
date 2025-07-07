package com.labs.sboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SbootRestClientLabsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("1. Starting SbootRestClientLabsApplication...");
		// 1. Load the configuration properties
		// 2. Create the Spring Boot application context
		//  2a. Callback methods to initialize beans or execute some custom logic
		// 3. Start the application

		SpringApplication.run(SbootRestClientLabsApplication.class, args);

		log.info("3. SbootRestClientLabsApplication started successfully!");

	}

	@Override
	public void run(String... args) throws Exception {
		// This method will be executed after the application context is loaded
		log.info("2. Executing run method in SbootRestClientLabsApplication...");

		// APPROACH #1 - Building Rest Client using Rest Template

//		// STEP 1: Create REST Template
//		RestTemplate restTemplate = new RestTemplate();
//		// STEP 2: Construct and Send Request
//		String baseUrl = "http://localhost:8080";
//
//		String response = restTemplate.getForObject(baseUrl, String.class);
//		log.info("Response from GET request: {}", response);
//
//		// POST Create Greeting
//		Greetings greeting = Greetings.builder().id(111).message("Hello, REST Template!").build();
//		log.info("Greeting sent to POST request: {}", greeting);
//		ResponseEntity postRes = restTemplate.postForEntity(baseUrl + "/greetings", greeting, Object.class);
//		// STEP 3: Receive Response and Print Details
//
//		// log status code
//		log.info("Response from GET request with Status code: {}", postRes.getStatusCode());
//		// log headers
//		log.info("Response from GET request with headers: {}", postRes.getHeaders());
//		// log response body
//		log.info("Response from POST request with message: {}", postRes.getBody());
//
//
//		// GET All Greetings
//		ResponseEntity<Collection> res = restTemplate.getForEntity(baseUrl + "/greetings", Collection.class);
//		// log status code
//		log.info("Response from GET request with Status code: {}", res.getStatusCode());
//        // log headers
//        log.info("Response from GET request with headers: {}", res.getHeaders());
//        // log body
//        log.info("Response from GET request with body: {}", res.getBody());
//
//
//        // PUT Update Greeting
//        Greetings updatedGreeting = Greetings.builder().id(111).message("Hello, REST Template! Updated").build();
//		RequestEntity<Greetings> reqEntity = new RequestEntity<>(updatedGreeting, HttpMethod.PUT,  URI.create(baseUrl + "/greetings/" + updatedGreeting.getId()));
//        ResponseEntity<Object> putRes = restTemplate.exchange(reqEntity, Object.class);
//        // log response message
//        log.info("Response from PUT request with message: {}", putRes.getBody());
//
//        // DELETE Greeting
//        restTemplate.delete(baseUrl + "/greetings/111");
//        log.info("Greeting with ID 111 deleted successfully!");

		// APPROACH #2 - Building Rest Client

		// STEP 1: Create Rest Client
		String baseUrl = "http://localhost:8080";
		RestClient restClient = RestClient.builder().baseUrl(baseUrl).build();
		// STEP 2: Construct and Send Request

		// POST request
		Greetings greeting = Greetings.builder().id(111).message("Hello, Rest Client!").build();
        ResponseMessage postRes = restClient
                .post()
                .uri("/greetings")
				.header("Accept", "application/json")
                .body(greeting)
                .retrieve()
                .body(ResponseMessage.class);

        log.info("Response from POST request with message: {}", postRes);

		// GET request
		Collection<Greetings> getRes = restClient
				.get()
				.uri("/greetings")
				.retrieve()
				.body(new ParameterizedTypeReference<Collection<Greetings>>() {});

		log.info("Response from GET request with body: {}", getRes);

		// STEP 3: Receive Response and Print Details

	}

}
