package com.labs.java.java8.stream;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamNumbersDemo {
    public static void main(String[] args) {
        List<Integer> nos = List.of(11,22,33,44,44,55,55,66,77,88,99,100);

        // sum of nos using for loop
//        int sum = 0;
//        for (int n : nos) {
//            sum += n;
//        }
//        0
//        0 + 11
//        11 + 22
//        33 + 33
//        66 + 44
//        110 + 55
//        ...
//        System.out.println("Sum: " + sum);


        // create stream
//        var result = nos.stream()
        // filter nos greater than 50
//                .filter(n -> n > 50)
        // square the nos
//                .map(n -> n * n)
        // print
//                .min(Integer::compareTo);
//                .max(Integer::compareTo);
//                .forEach(System.out::println);

//                .distinct()
//
//        .reduce(0, (a,b) -> a + b);
//
//        System.out.println("Output: " + result);
//        System.out.println("Average: " + result / nos.size());

        DoubleSummaryStatistics stats = nos.stream()
                .mapToDouble(x -> x) // convert IntStream
                .distinct()
                .summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());



    }
}
