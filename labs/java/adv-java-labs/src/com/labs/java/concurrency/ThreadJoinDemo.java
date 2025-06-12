package com.labs.java.concurrency;

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("Thread t1 state: " + Thread.currentThread().getState());
                for(int i = 1; i <= 50; i++) {
                    System.out.println("Hi");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("Thread t2 state: " + Thread.currentThread().getState());
                for(int i = 1; i <= 50; i++) {
                    System.out.println("Hello");
                }
            }
        });

//        System.out.println("Thread t1 state: " + t1.getState());
//        System.out.println("Thread t2 state: " + t2.getState());

        t1.start();
        t1.join();

        t2.start();
        t2.join();

//        System.out.println("Thread t1 state: " + t1.getState());
//        System.out.println("Thread t2 state: " + t2.getState());

        for(int i = 1; i <= 50; i++) {
            System.out.println("Welcome");
        }


    }
}
