package com.labs.spring.core.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hello, Spring Core!");

        // create few sample cars
//        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
//        Car car2 = new Car("Honda", "Civic", 2019, "Red");
//        Car car3 = new Car("Tata", "Nexon EV", 2025, "White");
//
//        Engine petrolEngine = new Engine("Petrol", 200, 10);
//        Engine electricEngine = new Engine("Electric", 300, 15);
//        Engine dieselEngine = new Engine("Diesel", 250, 12);
//
//        car1.setEngine(petrolEngine);
//        car2.setEngine(dieselEngine);
//        car3.setEngine(petrolEngine);
//
//        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + ", Year: " + car1.getYear() + ", Color: " + car1.getColor() + ", Engine: " + car1.getEngine().getType() + " with " + car1.getEngine().getHorsepower() + " HP");
//        System.out.println("Car 2: " + car2.getMake() + " " + car2.getModel() + ", Year: " + car2.getYear() + ", Color: " + car2.getColor() + ", Engine: " + car2.getEngine().getType() + " with " + car2.getEngine().getHorsepower() + " HP");
//        System.out.println("Car 3: " + car3.getMake() + " " + car3.getModel() + ", Year: " + car3.getYear() + ", Color: " + car3.getColor() + ", Engine: " + car3.getEngine().getType() + " with " + car3.getEngine().getHorsepower() + " HP");

        // STEP 1
        // Instantiate IoC container
//        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml", "beans-config-engine.xml");

        System.out.println(ctx);
        System.out.println("No of beans: " + ctx.getBeanDefinitionCount());

        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        // STEP 2
        // Access the bean from the container
        Car car1 = ctx.getBean("car1", Car.class);

//        Engine engine = ctx.getBean("dieselEngine", Engine.class);
//        engine.setHorsepower(300);

        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + ", Year: " + car1.getYear() + ", Color: " + car1.getColor() + ", Engine: " + car1.getEngine().getType() + " with " + car1.getEngine().getHorsepower() + " HP");



        // STEP 3
        // Close the container
        ctx.close();

//        System.out.println("No of beans: " + ctx.getBeanDefinitionCount());

    }
}
