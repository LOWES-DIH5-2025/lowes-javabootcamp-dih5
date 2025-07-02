package com.labs.spring.core.jconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(ctx);
        System.out.println("Bean Count: " + ctx.getBeanDefinitionCount());
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        Car car1 = ctx.getBean("car1", Car.class);

        // print all car details
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + ", Year: " + car1.getYear() + ", Color: " + car1.getColor() + ", Engine: " + car1.getEngine().getType() + " with " + car1.getEngine().getHorsepower() + " HP");

        ctx.registerShutdownHook(); // Register shutdown hook to close the context gracefully

    }
}
