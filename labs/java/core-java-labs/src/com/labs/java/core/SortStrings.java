package com.labs.java.core;

public class SortStrings {
    public static void main(String[] args) {
//        Input Data: Java, Simple, ObjectOriented, Threaded, Dynamic, Secure, Language
//        Expected Output: Dynamic, Java, Language, ObjectOriented, Secure, Threaded

        String[] words = {"Java", "Simple", "ObjectOriented", "Threaded", "Dynamic", "Secure", "Language"};

        // Sort the array using bubble sort algorithm
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (words[j].compareTo(words[j + 1]) > 0) {
                    // Swap words[j] and words[j+1]
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.print("Sorted strings: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
