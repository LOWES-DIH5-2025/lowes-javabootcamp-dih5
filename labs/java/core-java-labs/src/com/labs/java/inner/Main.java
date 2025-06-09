package com.labs.java.inner;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
//        Computer computer = new Desktop("Dell", "Intel i7", 16, 512, "Tower");
//        computer.printDetails();
//
//        computer = new Laptop("HP", "AMD Ryzen 5", 8, 256, 1.5);
//        computer.printDetails();

        // Anonymous class implementation of Computer
        Computer desktop = new Computer("Lenovo", "Intel i5", 16, 1024) {
            private String formFactor = "Tower";

            @Override
            public void printDetails() {
                System.out.println("Desktop Details:");
                System.out.println("Brand: " + getBrand());
                System.out.println("Processor: " + getProcessor());
                System.out.println("RAM Size: " + getRamSize() + " GB");
                System.out.println("Storage Size: " + getStorageSize() + " GB");
                System.out.println("Form Factor: " + formFactor);
            }
        };

        desktop.printDetails();

        AutoRenewable autoRenewable = new AutoRenewable() {
            @Override
            public void renew() {
                System.out.println("Auto-renewal process initiated.");
            }
        };

        autoRenewable.renew();
    }

}
