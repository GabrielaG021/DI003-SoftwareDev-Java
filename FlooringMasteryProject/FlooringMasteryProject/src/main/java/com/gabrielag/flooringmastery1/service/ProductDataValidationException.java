package com.gabrielag.flooringmastery1.service;

public class ProductDataValidationException extends Exception {
    public ProductDataValidationException(String message) { super(message); }

    public ProductDataValidationException(String message, Throwable cause) { super(message, cause); }
}
