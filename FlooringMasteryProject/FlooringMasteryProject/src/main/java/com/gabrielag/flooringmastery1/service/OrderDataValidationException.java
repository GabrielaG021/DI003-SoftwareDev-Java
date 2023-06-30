package com.gabrielag.flooringmastery1.service;

import com.gabrielag.flooringmastery1.dto.Order;

public class OrderDataValidationException extends Exception {
    public OrderDataValidationException(String message) { super(message); }

    public OrderDataValidationException(String message, Throwable cause) { super(message, cause); }
}
