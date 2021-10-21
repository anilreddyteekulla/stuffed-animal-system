package com.stuffed.animal.api.exceptions;

public class NoPersonFoundException extends RuntimeException {
    public NoPersonFoundException(String message) {
        super(message);
    }
}