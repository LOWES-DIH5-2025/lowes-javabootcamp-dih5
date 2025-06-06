package com.labs.java.core;


import java.util.Scanner;

/**
 * A simple Java program for temperature conversion from
 * Celsius to Fahrenheit and Fahrenheit to Celsius using IF ELSE
 */
public class TempConverter4 {
    public static void main(String[] args) {
//        Welcome to Temperature Converter App!!!
//
//        1) Celsius to Fahrenheit
//        2) Fahrenheit to Celsius
//        3) Exit
//
//        Enter the Option:
//
//        (if option 1) Enter the value in Celsius:
//        (if option 2) Enter the value in Fahrenheit:
//
//        Print the the converted temperature
//
//                (If option 3) Thank you!!

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Temperature Converter App!!!");
        System.out.println("1) Celsius to Fahrenheit");
        System.out.println("2) Fahrenheit to Celsius");
        System.out.println("3) Exit");
        System.out.print("Enter the Option: ");

        int option = scanner.nextInt();

        if (option == 1) {
            System.out.print("Enter the value in Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
        } else if (option == 2) {
            System.out.print("Enter the value in Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println(fahrenheit + " degree Fahrenheit is equal to " + celsius + " in Celsius");
        } else if (option == 3) {
            System.out.println("Thank you!!");
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    scanner.close();

    }
}
