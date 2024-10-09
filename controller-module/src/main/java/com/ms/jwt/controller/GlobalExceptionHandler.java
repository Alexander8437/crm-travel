package com.ms.jwt.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Log the exception message for debugging
        String errorMessage = "Duplicate key error: " + ex.getMostSpecificCause().getMessage();
        
        // Return a response with the appropriate HTTP status and a custom message
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}