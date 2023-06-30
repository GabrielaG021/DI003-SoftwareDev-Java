package com.gabrielag.flooringmastery1.service;

public class TaxDataValidationException extends Exception {
    public TaxDataValidationException(String message) { super(message); }

    public TaxDataValidationException(String message, Throwable cause) { super(message, cause); }
}
