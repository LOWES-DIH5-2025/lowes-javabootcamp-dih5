package com.labs.java.core;


import java.util.Scanner;

/**
 * A simple Java program for temperature conversion from
 * Celsius to Fahrenheit and Fahrenheit to Celsius using Switch Case
 */
public class TempConverter5 {
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
//        (If option 3) Thank you!!

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Temperature Converter App!!!");
        System.out.println("1) Celsius to Fahrenheit");
        System.out.println("2) Fahrenheit to Celsius");
        System.out.println("3) Exit");
        System.out.print("Enter the Option: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter the value in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
            }

            case 2 -> {
                System.out.print("Enter the value in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double celsius = (fahrenheit - 32) * 5 / 9;
                System.out.println(fahrenheit + " degree Fahrenheit is equal to " + celsius + " in Celsius");
            }

            case 3 -> System.out.println("Thank you!!");

            default -> System.out.println("Invalid option. Please try again.");
        }

        scanner.close();
    }

}
