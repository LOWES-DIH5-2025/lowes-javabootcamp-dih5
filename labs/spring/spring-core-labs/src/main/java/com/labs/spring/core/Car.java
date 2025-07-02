package com.labs.spring.core;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private Engine engine;

    public Car() {
        System.out.println("Car default constructor called...");
    }

    public Car(String make, String model, int year, String color, Engine engine) {
        System.out.println("Car parameterized constructor called...");
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

    public void setEngine(Engine engine) {
        System.out.println("Car Engine setter called..");
        this.engine = engine;
    }
}
