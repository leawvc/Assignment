package com.example.assignment.Controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }
    // validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        String error;
        error = ex.getBindingResult().getFieldError().getDefaultMessage();
        return error;
    }
}
