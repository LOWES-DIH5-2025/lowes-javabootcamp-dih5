package com.labs.scloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication implements CommandLineRunner {

	@Value("${message:Hello from Config Client!}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Config Client Message: " + message);
	}

}
