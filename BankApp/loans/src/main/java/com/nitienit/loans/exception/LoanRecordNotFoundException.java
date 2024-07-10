package com.nitienit.loans.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoanRecordNotFoundException extends RuntimeException{
    public LoanRecordNotFoundException(String message) {
        super(message);
        log.info("LoanRecordNotFoundException exception raised");
    }
}
