package com.lowes.bankingapp.service;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.exception.AccountValidationException;
import com.lowes.bankingapp.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AccountServiceTreeSetImpl implements AccountService {
    private Set<Account> accounts = new TreeSet<>();

    @Override
    public int createAccount(Account account) throws AccountValidationException {
        return 0;
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
        return List.of();
    }
}
