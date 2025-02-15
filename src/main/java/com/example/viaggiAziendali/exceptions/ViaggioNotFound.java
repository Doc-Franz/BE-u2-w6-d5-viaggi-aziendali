package com.example.viaggiAziendali.exceptions;

public class ViaggioNotFound extends RuntimeException {
    public ViaggioNotFound(String message) {
        super(message);
    }
}
