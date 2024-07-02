package com.nitienit.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMappingAPI handleException(ResourceNotFoundException ex) {
		log.info("[GlobalExceptionHandler] :: handleException() case:ResourceNotFoundExcepetion starts");
		var error = new ErrorMappingAPI();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
		error.setErrorMessage(ex.getMessage());
		error.setErrorDateTime(LocalDateTime.now());
		log.info("[GlobalExceptionHandler] :: handleException() ends");
		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMappingAPI handleException(Exception ex) {
		log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
		var error = new ErrorMappingAPI();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
		error.setErrorMessage(ex.getMessage());
		error.setErrorDateTime(LocalDateTime.now());
		log.info("[GlobalExceptionHandler] :: handleException() case:Exception starts");
		return error;
	}
}
