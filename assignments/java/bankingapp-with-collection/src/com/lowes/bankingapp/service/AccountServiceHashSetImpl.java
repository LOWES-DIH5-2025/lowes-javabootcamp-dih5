package com.lowes.bankingapp.service;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.exception.AccountValidationException;
import com.lowes.bankingapp.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountServiceHashSetImpl implements AccountService{
    private Set<Account> accounts = new HashSet<>();
    private static int idCounter = 1;

    @Override
    public int createAccount(Account account) throws AccountValidationException {
        if (account == null) {
            throw new AccountValidationException("Account cannot be null");
        }
        // Generate a unique ID for the new account
        account.setId(idCounter++);
        accounts.add(account);
        System.out.println(account.getType() + " Account created successfully!!!"); // Assuming ID starts from 1
        return account.getId();
    }

    @Override
    public boolean updateAccount(int id, Account updatedAccount) throws AccountException {
        return false;
    }

    @Override
    public boolean deleteAccount(int id) throws AccountNotFoundException {
        return false;
    }

    @Override
    public Account getAccount(int id) throws AccountNotFoundException {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }
}
