package com.labs.java.core;

public class AccountManager {
    public static void main(String[] args) {

        Account.print();
        System.out.println("Bank Name: " + Account.BANK_NAME);
//        // Create  a few account objects and test the method

        Account account1 = new Account(1001, "John Doe", "Savings", 5000.0);
        Account account2 = new Account(1002, "Jane Smith", "Checking", 3000.0);
        Account account3 = new Account(1003, "Alice Johnson", "Savings", 7000.0);

        account1.closeAccount();
        account1.openAccount();

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}
