package com.lowes.bankingapp.exception;

public class AccountValidationException extends AccountException {
    public AccountValidationException() {
    }

    public AccountValidationException(String message) {
        super(message);
    }

    public AccountValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
