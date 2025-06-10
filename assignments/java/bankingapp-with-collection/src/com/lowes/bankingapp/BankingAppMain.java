package com.lowes.bankingapp;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.model.*;
import com.lowes.bankingapp.service.*;

import java.time.LocalDate;
import java.util.Collection;

public class BankingAppMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking Application!");

        AccountService service = new AccountServiceArrListImpl();
//        AccountService service = new AccountServiceHashSetImpl();
//        AccountService service = new AccountServiceTreeSetImpl();
//        AccountService service = new AccountServiceHashMapImpl();


        // Here you can create instances of Account, Loan, etc.
        // and call their methods to test the functionality.

        // create a savings account
        Account savingsAccount = new SavingsAccount("John Doe", "Savings", 4.5, true, 5000.0);

        // create a deposit account
        Account depositAccount = new DepositAccount("Jane Smith", "Deposit", 5.0, true, 1, 100000.0, LocalDate.of(2025, 1, 1));

        // create a loan account
        Account loanAccount = new LoanAccount("Alice Johnson", "Loan", 6.0, true, 5, 200000.0, LoanType.HOME_LOAN, LocalDate.of(2024, 1, 1));

        try {
            service.createAccount(savingsAccount);
            service.createAccount(depositAccount);
            service.createAccount(loanAccount);
        }catch(AccountException e) {
            System.err.println("Error creating account: " + e.getMessage());
        }

        // Get all accounts
        Collection<Account> accounts = service.getAllAccounts();
        for(Account account : accounts) {
            if (account != null) {
//                System.out.println(account);
                System.out.printf("%d \t %s \t %s \t %.2f \n", account.getId(), account.getName(), account.getType(), account.checkCurrentBalance());

            }
        }

    }
}
