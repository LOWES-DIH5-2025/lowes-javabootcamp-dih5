package com.lowes.bankingapp.model;

public class SavingsAccount extends Account {

    public SavingsAccount() {
        System.out.println("Savings default constructor...");
    }

    public SavingsAccount(String name, String type, double roi, boolean isActive, double balance) {
        super(name, type, roi, true);
        this.balance = balance;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void openAccount() {
        setActive(true);
        System.out.println("Savings Account opened!!!");
    }

    /*
    * Overriding rules
    * 1. Method name should be same
    * 2. Return type should be same or sub-type of overridden method
    * 3. Parameters should be same
    * 4. Throws should be same or sub-type of overridden method
     */
    @Override
    public void closeAccount() {
        System.out.println("Savings Account closed...");
    }

    @Override
    public double checkCurrentBalance() {
        return this.balance;
    }

    public double checkCurrentBalance(boolean status) {
        return status ? this.balance : 0.0;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    // static methods will not be overridden
    public static void printDetails() {
        System.out.println("Printing Savings Account Details...");
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", type=" + getType() +
                ", roi=" + getRoi() +
                ", isActive=" + isActive() +
                ", balance=" + balance +
                '}';
    }
}

