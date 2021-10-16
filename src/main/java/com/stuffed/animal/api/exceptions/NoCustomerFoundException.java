package com.stuffed.animal.api.exceptions;

public class NoCustomerFoundException extends RuntimeException {
    public NoCustomerFoundException(String message) {
        super(message);
    }
}