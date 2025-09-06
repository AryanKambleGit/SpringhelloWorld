package com.codingshuttle.youtube.Learning.Rest.APIs.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}