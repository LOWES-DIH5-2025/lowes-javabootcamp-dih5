package com.labs.java.java8;

public class AccountFP {

    public double withdraw(double balance, double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
        return balance;
    }

    public double deposit(double balance, double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
        return balance;
    }
}
