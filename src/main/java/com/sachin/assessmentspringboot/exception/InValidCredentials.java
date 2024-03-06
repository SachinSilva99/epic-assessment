package com.sachin.assessmentspringboot.exception;

public class InValidCredentials extends RuntimeException{
    public InValidCredentials() {
    }

    public InValidCredentials(String message) {
        super(message);
    }
}
