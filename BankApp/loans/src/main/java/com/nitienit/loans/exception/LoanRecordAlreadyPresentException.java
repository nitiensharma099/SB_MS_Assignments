package com.nitienit.loans.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoanRecordAlreadyPresentException extends RuntimeException{

    public LoanRecordAlreadyPresentException(String message) {
        super(message);
        log.info("LoanRecordAlreadyPresentException :: raised ");
    }
}
