package org.example.recapprojectspring.exceptions;

public class NoTodoWasCreatedException extends RuntimeException {
    public NoTodoWasCreatedException(String message) {
        super(message);
    }
}
