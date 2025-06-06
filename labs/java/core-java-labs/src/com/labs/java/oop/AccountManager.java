package com.labs.java.oop;

import java.time.LocalDate;

public class AccountManager {
    public static void main(String[] args) {
//        SavingsAccount savings = new SavingsAccount();
//        savings.setId(100);
//        savings.setBalance(5000.0);
//        SavingsAccount.printDetails();
//        System.out.println(savings.getId() + " " + savings.getBalance());


        Account savings1 = new SavingsAccount(100, "John", "SAVINGS", 6.5, true, 5000.0);
        System.out.println(savings1.checkCurrentBalance());

        if(savings1 instanceof SavingsAccount) {
            ((SavingsAccount) savings1).withdraw(1000);
            ((SavingsAccount) savings1).deposit(2000);
        }

//        savings1.closeAccount(); // Dynamic Method Dispatch
//        Account.printDetails();
        System.out.println(savings1);

        Account deposit1 = new DepositAccount(101, "Kumar", "DEPOSIT", 7.5, true, 1,100000.0, LocalDate.of(2025,1,1));
        System.out.println(deposit1);
        System.out.format("%.2f", deposit1.checkCurrentBalance());

        Account loan1 = new LoanAccount(102, "Josh", "LOAN", 9.5, true, 5, 500000.0, LoanType.CAR_LOAN, LocalDate.of(2024,1,1));
        System.out.println(loan1);
        System.out.format("%.2f", loan1.checkCurrentBalance());

        DepositAccount deposit2 = new DepositAccount(105, "Kumar", "DEPOSIT", 7.5, true, 1,100000.0, LocalDate.of(2025,1,1));
        System.out.println(deposit2);
        deposit2.preClose();
        deposit2.notification();
        System.out.format("%.2f", deposit2.checkCurrentBalance());


    }
}
