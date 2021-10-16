package com.stuffed.animal.api.exceptions;

public class NoStuffedAnimalFoundException extends RuntimeException {
    public NoStuffedAnimalFoundException(String message) {
        super(message);
    }
}