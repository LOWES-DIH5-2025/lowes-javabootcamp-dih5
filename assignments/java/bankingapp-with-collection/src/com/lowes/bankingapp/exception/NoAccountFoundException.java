package com.lowes.bankingapp.exception;

public class NoAccountFoundException extends AccountException {
    public NoAccountFoundException() {
    }

    public NoAccountFoundException(String message) {
        super(message);
    }

    public NoAccountFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
