package com.labs.sboot;

import com.labs.sboot.model.Greetings;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "Spring Boot REST Labs",
				version = "1.0",
				description = "Demo Application for Spring Boot REST API with Swagger"
		))
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

//		GreetingService service = ctx.getBean("greetingService",GreetingService.class);
//		System.out.println("Total Greetings: " + service.getAllGreetings().size());
//        try {
//            service.deleteGreeting(123);
//        } catch (NoGreetingsFoundException e) {
//			System.out.println("Error: " + e.getMessage());
//        }
    }


}
