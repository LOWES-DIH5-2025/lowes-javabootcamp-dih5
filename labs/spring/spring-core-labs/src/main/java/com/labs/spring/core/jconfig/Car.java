package com.labs.spring.core.jconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Car {
    @Value("${car.make:Toyota}") // Using property placeholder with default value
    private String make;
    @Value("${car.model:Camry}") // Using property placeholder with default value
    private String model;
    @Value("${car.year:2023}") // Using property placeholder with default value
    private int year;
//    @Value("#{electricEngine.type}") // Using SpEL to inject value from another bean property
    @Value("${car.color:Red}") // Using property placeholder with default value
    private String color;

    @Autowired(required = false) // Autowiring the Engine bean, not required
    @Qualifier("petrolEngine")// Use @Qualifier to specify which Engine bean to inject
    private Engine engine;

    public Car() {
        System.out.println("Car default constructor called...");
    }

//    @Autowired
    public Car(Engine engine) {
        System.out.println("Car constructor called with Engine...");
        this.engine = engine;
    }


    public Car(String make, String model, int year, String color) {
        System.out.println("Car parameterized constructor called...");
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Car(String make, String model, int year, String color, Engine engine) {
        System.out.println("Car parameterized constructor with Engine called...");
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

//    @Autowired
//    @Qualifier("electricEngine") // Use @Qualifier to specify which Engine bean to inject
    public void setEngine(Engine engine) {
        System.out.println("Car Engine setter called..");
        this.engine = engine;
    }

    public void init() {
        System.out.println("Car Bean Initialized...");
    }

    public void destroy() {
        System.out.println("Car Bean Destroyed...");
    }
}
