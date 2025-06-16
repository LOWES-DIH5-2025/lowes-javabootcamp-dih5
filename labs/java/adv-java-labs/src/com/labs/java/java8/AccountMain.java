package com.labs.java.java8;

public class AccountMain {
    public static void main(String[] args) {
        AccountOOP account = new AccountOOP(12345, "John Doe", 1000.0);

        // Test deposit
        account.deposit(500.0);
        System.out.println("Current balance: " + account.getBalance());

        // Test withdrawal
        account.withdraw(300.0);
        System.out.println("Current balance: " + account.getBalance());

        // Test insufficient funds
        account.withdraw(1500.0);
        System.out.println("Current balance: " + account.getBalance());

        // Test negative deposit
        account.deposit(-200.0);

        AccountFP accountFP = new AccountFP();
        double balance = 3000.0;
        // Test functional programming style deposit
        balance = accountFP.deposit(balance, 500.0);
        System.out.println("Current balance after FP deposit: " + balance);
        // Test functional programming style withdrawal
        balance = accountFP.withdraw(balance, 300.0);
        System.out.println("Current balance after FP withdrawal: " + balance);
    }
}
