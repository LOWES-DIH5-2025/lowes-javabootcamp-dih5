package com.labs.spring.core.jconfig;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@ComponentScan(basePackages = "com.labs.spring.core.jconfig")
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan// Scans for properties files
@ImportResource("classpath:beans-config-engine.xml") // Import XML configuration if needed
public class AppConfig {

//    <bean id="car1" class="com.labs.spring.core.xml.Car" autowire="byType" init-method="init" destroy-method="destroy">
//        <constructor-arg name="make" value="Toyota"/>
//        <constructor-arg name="model" value="Camry"/>
//        <constructor-arg name="year" value="2020"/>
//        <constructor-arg name="color" value="Blue"/>
//    </bean

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car1() {
//        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
//        car1.setEngine(petrolEngine()); // Setter injection

//        Car car1 = new Car("Toyota", "Camry", 2020, "Blue", electricEngine()); // Constructor injection

        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        return car1;
    }

//    @Bean
//    @Lazy
//    @Scope("prototype") // Prototype scope
//    public Engine petrolEngine() {
//        return new PetrolEngine();
//    }

//    @Bean
//    @Primary // This will be the default Engine bean if no qualifier is specified
//    public Engine dieselEngine() {
//        return new DieselEngine();
//    }

    @Bean(autowireCandidate = false)
    public Engine electricEngine() {
        return new ElectricEngine();
    }

    // Optiona. This bean is used to resolve property placeholders in the application context
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

}
