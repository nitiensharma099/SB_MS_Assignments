package com.nitienit.accounts.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorMappingAPI handleException(ResourceNotFoundException ex) {
        log.info("[GlobalExceptionHandler] :: handleException() case:ResourceNotFoundExcepetion starts");
        var error = new ErrorMappingAPI();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        log.info("[GlobalExceptionHandler] :: handleException() ends");
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
