package com.nitienit.loans.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanRecordAlreadyPresentException.class)
    public ErrorMappingAPI exceptionHandler(LoanRecordAlreadyPresentException ex) {
        var error = new ErrorMappingAPI();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        return error;
    }

    @ExceptionHandler(LoanRecordNotFoundException.class)
    public ErrorMappingAPI exceptionHandler(LoanRecordNotFoundException ex) {
        var error = new ErrorMappingAPI();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMappingAPI handleException(Exception ex) {
        log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
        var error = new ErrorMappingAPI();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
        return error;
    }
}
