package com.lowes.bankingapp.service;

import com.lowes.bankingapp.exception.AccountValidationException;
import com.lowes.bankingapp.model.Account;

public class AccountServiceArrImpl implements AccountService {
    private Account[] accounts = new Account[10];
    private static int accountId = 1;

    @Override
    public int createAccount(Account account) throws AccountValidationException {

        if(account == null) {
            throw new AccountValidationException("Account cannot be null");
        }
        //Generate a unique ID for the new account
        account.setId(accountId++);
        accounts[account.getId() - 1] = account;
        System.out.println(account.getType() + " Account created successfully!!!");// Assuming ID starts from 1
        return account.getId();
    }

    @Override
    public boolean updateAccount(int id, Account updatedAccount) {
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

    @Override
    public Account getAccount(int id) {
        if (id > 0 ) {
            for(Account account : accounts) {
                if (account != null && account.getId() == id) {
                    return account;
                }
            }
        }
        return null;
    }

    @Override
    public Account[] getAllAccounts() {
        return accounts;
    }
}
