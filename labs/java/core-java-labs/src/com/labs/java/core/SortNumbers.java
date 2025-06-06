package com.labs.java.core;

/**
 * Sort given nos
 */
public class SortNumbers {
    public static void main(String[] args) {
//        Input Data: 30, 50, 20, 10, 50, 40
//        Expected Output: 10, 20, 30, 40, 50, 60
        int[] nos = {30, 50, 20, 10, 50, 40};

        // Sort the array using bubble sort algorithm
        for (int i = 0; i < nos.length - 1; i++) {
            for (int j = 0; j < nos.length - i - 1; j++) {
                if (nos[j] > nos[j + 1]) {
                    // Swap nos[j] and nos[j+1]
                    int temp = nos[j];
                    nos[j] = nos[j + 1];
                    nos[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.print("Sorted numbers: ");
        for (int no : nos) {
            System.out.print(no + " ");
        }


    }
}
