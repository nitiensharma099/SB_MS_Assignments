package com.nitienit.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorMappingAPI {

	private Integer errorCode;
	private String errorStatus;
	private String errorMessage;
	private LocalDateTime errorDateTime;
}