package com.lowes.bankingapp.service;

import com.lowes.bankingapp.exception.AccountException;
import com.lowes.bankingapp.exception.AccountValidationException;
import com.lowes.bankingapp.model.Account;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {
    // createAccount method to create a new account
    int createAccount(Account account) throws AccountValidationException;
    // updateAccount method to update an existing account
    boolean updateAccount(int id, Account updatedAccount) throws AccountException;
    // deleteAccount method to delete an account
    boolean deleteAccount(int id) throws AccountNotFoundException;
    // getAccount method to retrieve account details
    Account getAccount(int id) throws AccountNotFoundException;
    // getAllAccounts method to retrieve all accounts
    Account[] getAllAccounts();
}
