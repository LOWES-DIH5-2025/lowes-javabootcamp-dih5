package com.labs.spring.core.jconfig;

// @Controller, @RestController, @Service, @Repository
public abstract class Engine {

    private String type;
    private int horsepower;
    private int torque;

    public Engine() {
        System.out.println("Engine default constructor called...");
    }

    private Engine(String type, int horsepower, int torque) {
        this.type = type;
        this.horsepower = horsepower;
        this.torque = torque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }
}
