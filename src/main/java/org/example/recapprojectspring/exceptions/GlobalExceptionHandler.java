package org.example.recapprojectspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(NoTaskWithThisIDFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoTaskWithThisIdFoundException( NoTaskWithThisIDFoundException e){
    return e.getMessage();
}
    @ExceptionHandler(NoTodoWasCreatedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoTaskWasCreatedException( NoTodoWasCreatedException e){
        return e.getMessage();
    }

}
