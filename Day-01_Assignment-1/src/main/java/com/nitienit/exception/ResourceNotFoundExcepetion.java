package com.nitienit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceNotFoundExcepetion extends RuntimeException{

	
	private static final Logger log = LoggerFactory.getLogger(ResourceNotFoundExcepetion.class);

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExcepetion(String message) {
		super(message);
		log.info("[ResourceNotFoundExcepetion] :: calling");
	}
	
	
	

}
