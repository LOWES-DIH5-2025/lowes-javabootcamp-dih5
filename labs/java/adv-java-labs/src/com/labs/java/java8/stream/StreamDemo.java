package com.labs.java.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // list of countries
        List<String> countries = Arrays.asList(
            "United States", "Canada", "Mexico", "United Kingdom",
            "Germany", "France", "Italy", "Spain",
            "Australia", "New Zealand", "Japan", "China", "United Kingdom");
        // 1. create stream from countries list
        var result = countries.stream()
        // 2. filter countries that start with 'U'
                .filter(country -> country.startsWith("U"))
        // 3. make all letters uppercase
//                .map(country -> country.toUpperCase())
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.reverseOrder())

        // 4. print
//                .forEach(System.out::println);
//                .count();
        // 5. count the number of countries starting with 'U'
//                .collect(Collectors.toList());
//                .collect(Collectors.toSet());
                .collect(Collectors.toMap(String::toString, String::length));

        System.out.println("Output: " + result);
    }
}
