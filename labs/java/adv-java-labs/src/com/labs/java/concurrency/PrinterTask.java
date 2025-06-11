package com.labs.java.concurrency;

import java.util.concurrent.Callable;

public class PrinterTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("****Entering " + Thread.currentThread().getName());
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
        System.out.println("****Exiting " + Thread.currentThread().getName());
        return "Completed Task - " + Thread.currentThread().getName();
    }
}
