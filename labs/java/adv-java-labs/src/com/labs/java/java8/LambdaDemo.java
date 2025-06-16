package com.labs.java.java8;

public class LambdaDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 25; i++) {
                    System.out.println("Hi");
                }
            }
        });

        Thread t2 = new Thread(() -> {
                for(int i = 1; i <= 25; i++) {
                    System.out.println("Hello");
                }
        });

        t1.start();
        t2.start();

    }
}
