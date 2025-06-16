package com.labs.java.java8;

public class AccountOOP {

    private int accountNo;
    private String name;
    private double balance;

    public AccountOOP(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }

}
