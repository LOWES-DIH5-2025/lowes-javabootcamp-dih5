package com.labs.java.java8;

public class DateTimeDemo {

    public static void main(String[] args) {
        // example of using System.currentTimeMillis()
        long startTime = System.currentTimeMillis();

        // Simulate some processing time
        for(int i =0; i < 100000; i++) {
            for(int j = 0; j < 100000; j++) {
                for(int k = 0; k < 100; k++) {
                    // This inner loop is just to increase the processing time
//                    int z = i * j * k; // This inner loop is just to increase the processing time

                }
                // This inner loop is just to increase the processing time
            }
            // Just a loop to simulate work

        }

        long endTime = System.currentTimeMillis();

        // Calculate the elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time in milliseconds: " + elapsedTime);
    }
}
