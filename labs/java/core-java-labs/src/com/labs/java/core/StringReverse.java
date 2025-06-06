package com.labs.java.core;

public class StringReverse {
    public static void main(String[] args) {
        // A simple Java program to reverse a string
//        Input Data: Welcome to Java Training
//        Expected Output: gniniarT avaJ ot emocleW

        String input = "Welcome to Java Training";

        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed.concat(String.valueOf(input.charAt(i)));
        }

        System.out.println(reversed);
    }
}
