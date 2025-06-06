package com.labs.java.core;


/**
 * A simple Java program to convert Celsius to Fahrenheit
 * taking the input from command line argument
 */
public class TempConverter2 {
    public static void main(String[] args) {
        // Read the input from command line argument
        // Input a degree in Celsius: 100.0
        // Expected Output: 212
        double celsius = Double.parseDouble(args[0]);
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
    }
}
