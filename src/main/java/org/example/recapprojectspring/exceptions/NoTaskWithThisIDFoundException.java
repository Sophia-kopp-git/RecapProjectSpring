package org.example.recapprojectspring.exceptions;

public class NoTaskWithThisIDFoundException extends RuntimeException {
    public NoTaskWithThisIDFoundException(String message) {
        super(message);
    }
}
