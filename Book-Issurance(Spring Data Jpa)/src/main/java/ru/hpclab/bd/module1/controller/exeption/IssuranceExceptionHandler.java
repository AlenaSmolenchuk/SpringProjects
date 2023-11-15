package ru.hpclab.bd.module1.controller.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Basic handler for IssuranceException.
 */
@ControllerAdvice
public class IssuranceExceptionHandler {
    /**
     * Handles IssuranceException and returns BAD_REQUEST.
     * @param e user exception
     * @return response with exception message and BAD_REQUEST status code
     */
    @ExceptionHandler
    public ResponseEntity<String> onUserException(final IssuranceException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
