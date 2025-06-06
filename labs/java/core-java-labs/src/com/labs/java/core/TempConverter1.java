package com.labs.java.core;

/**
 * A simple Java program to convert Celsius to Fahrenheit.
 * This program demonstrates basic arithmetic operations and output formatting.
 */
public class TempConverter1 {
    public static void main(String[] args) {
//        Input a degree in Celsius: 100.0

//        Expected Output:
//        100.0 degree Celsius is equal to 212 in Fahrenheit

//        Formula: (celsius * 9 / 5 ) + 32
        double celsius = 100.5;
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
    }
}
