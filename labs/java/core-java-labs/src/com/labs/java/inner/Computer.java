package com.labs.java.inner;

public abstract class Computer {
    private String brand;
    private String processor;
    private int ramSize; // in GB
    private int storageSize; // in GB

    public Computer(String brand, String processor, int ramSize, int storageSize) {
        this.brand = brand;
        this.processor = processor;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public abstract void printDetails();
}

//class Desktop extends Computer {
//    private String formFactor; // e.g., Tower, All-in-One
//
//    public Desktop(String brand, String processor, int ramSize, int storageSize, String formFactor) {
//        super(brand, processor, ramSize, storageSize);
//        this.formFactor = formFactor;
//    }
//
//    @Override
//    public void printDetails() {
//        System.out.println("Desktop Details:");
//        System.out.println("Brand: " + super.getBrand());
//        System.out.println("Processor: " + super.getBrand());
//        System.out.println("RAM Size: " + super.getRamSize() + " GB");
//        System.out.println("Storage Size: " + super.getStorageSize() + " GB");
//        System.out.println("Form Factor: " + this.formFactor);
//    }
//
//}

//class Laptop extends Computer {
//    private double weight; // in kg
//
//    public Laptop(String brand, String processor, int ramSize, int storageSize, double weight) {
//        super(brand, processor, ramSize, storageSize);
//        this.weight = weight;
//    }
//
//    @Override
//    public void printDetails() {
//        System.out.println("Laptop Details:");
//        System.out.println("Brand: " + super.getBrand());
//        System.out.println("Processor: " + super.getProcessor());
//        System.out.println("RAM Size: " + super.getRamSize() + " GB");
//        System.out.println("Storage Size: " + super.getStorageSize() + " GB");
//        System.out.println("Weight: " + this.weight + " kg");
//    }
//}
