package com.labs.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("####Entering " + Thread.currentThread().getName());

        // Approach 1: Using Thread class
//        for (int i = 1; i <= 3; i++) {
//            Printer printer = new Printer();
//            printer.setName("Printer#" + i);
//            printer.start();
//        }

        // Approach 2: Using Runnable interface with Thread class
//        for (int i = 1; i <= 3; i++) {
//            PrinterRunnable printerRunnable = new PrinterRunnable();
//            Thread thread = new Thread(printerRunnable);
//            thread.setName("PrinterRunnable#" + i);
//            thread.start();
//        }


        // Approach 3: Using Callable interface with ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            PrinterTask printerTask = new PrinterTask();
            Future<String> future = executorService.submit(printerTask);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            futureList.add(future);
        }

        for(Future<String> future : futureList) {
            try {
                String result = future.get(); // This will block until the task is complete
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error retrieving result: " + e.getMessage());
            }
        }
        executorService.shutdown();

        System.out.println("####Exiting " + Thread.currentThread().getName());

    }
}
