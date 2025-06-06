package com.labs.java.core;


/**
 * A simple Java program to convert Celsius to Fahrenheit
 * taking the input from command line argument with validation
 */
public class TempConverter3 {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please provide a degree in Celsius as a command line argument.");
            System.exit(0);
//            return;
        }

        double celsius = Double.parseDouble(args[0]);
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
    }
}
