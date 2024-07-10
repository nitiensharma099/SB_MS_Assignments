package com.nitienit.cards.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(CardDetailsNotFoundException.class)
    public ErrorMappingApi handleException(CardDetailsNotFoundException ex) {
        log.info("[GlobalExceptionHandler] :: handleException() case:ResourceNotFoundExcepetion starts");
        var error = new ErrorMappingApi();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        log.info("[GlobalExceptionHandler] :: handleException() ends");
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMappingApi handleException(Exception ex) {
        log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
        var error = new ErrorMappingApi();
        error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setErrorMessage(ex.getMessage());
        error.setErrorDateTime(LocalDateTime.now());
        log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
        return error;
    }
}
