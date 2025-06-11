package com.labs.java.concurrency;

public class PrinterRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("****Entering " + Thread.currentThread().getName());
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
//            try {
//                Thread.sleep(1000); // Sleep for 1 second
//            } catch (InterruptedException e) {
//                System.out.println("Thread interrupted: " + e.getMessage());
//            }

        }
        System.out.println("****Exiting " + Thread.currentThread().getName());
    }
}
