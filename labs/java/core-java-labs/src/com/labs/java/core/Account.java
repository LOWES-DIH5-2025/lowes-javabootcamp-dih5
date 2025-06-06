package com.labs.java.core;

public class Account {

    public static final String BANK_NAME = "Lowes Bank"; // static variable, shared across all instances

    // static block
    static {
        System.out.println("Static block #1 called");
    }

    static {
        System.out.println("Static block #2 called");

    }

    // instance block
    {
        System.out.println("Instance block called");
    }

    // private, protected, public, default
    // state or attributes
    int accountNo;
    String name;
    String accountType;
    double balance;
    boolean isActive;

    // default constructor
    public Account() {
        System.out.println("Default constructor called");
    }

    // constructor
    public Account(int accountNo, String name, String accountType, double balance) {
        System.out.println("Parameterized constructor called");
        this.accountNo = accountNo;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.isActive = true; // default to active
    }

    // behaviours or methods
    public void openAccount() {
        System.out.println("Account opened successfully");
        isActive = true;
    }

    public void closeAccount() {
        System.out.println("Account closed successfully");
        isActive = false;
    }

    public static void print() {
        System.out.println("This is a static method in Account class");
        System.out.println("Bank Name: " + BANK_NAME);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
