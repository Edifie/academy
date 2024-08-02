package com.ctw.workstation.shared.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String className) {
        super(className + " not found.");
    }
}