package com.labs.spring.core.xml;

public class Engine {
    private String type;
    private int horsepower;
    private int torque;

    private Engine() {
        System.out.println("Engine default constructor called...");
    }

    public static Engine createPetrolEngine() {
        System.out.println("Factory method called. Creating Petrol Engine...");
        return new Engine("Petrol", 150, 20);
    }

    public static Engine createElectricEngine() {
        System.out.println("Factory method called. Creating Electric Engine...");
        return new Engine("Electric", 190, 15);
    }

    public static Engine createDieselEngine() {
        System.out.println("Factory method called. Creating Diesel Engine...");
        return new Engine("Diesel", 250, 25);
    }

//    public static Engine createEngine(String type) {
//        switch (type.toLowerCase()) {
//            case "petrol":
//                return createPetrolEngine();
//            case "electric":
//                return createElectricEngine();
//            case "diesel":
//                return createDieselEngine();
//            default:
//                throw new IllegalArgumentException("Unknown engine type: " + type);
//        }
//    }

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
