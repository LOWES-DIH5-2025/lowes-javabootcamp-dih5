package com.labs.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
// @ComponentScan
// @Configuration
// @EnableAutoConfiguration
public class SbootRestLabsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbootRestLabsApplication.class, args);

		Greetings greetings = ctx.getBean("greetings", Greetings.class);
		System.out.println(greetings.getMessage());

		// Bean Count
		System.out.println("Total Beans: " + ctx.getBeanDefinitionCount());
//		Arrays.stream(ctx.getBeanDefinitionNames())
//				.sorted()
//				.forEach(System.out::println);
	}


}
