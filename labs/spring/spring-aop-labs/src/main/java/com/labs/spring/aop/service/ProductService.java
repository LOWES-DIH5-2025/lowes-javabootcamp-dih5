package com.labs.spring.aop.service;

public class ProductService {
    public void doWork() {
        System.out.println("ProductService: Doing work...");
    }

    public void takeBreak() {
        System.out.println("ProductService: Taking a break...");
    }
}
