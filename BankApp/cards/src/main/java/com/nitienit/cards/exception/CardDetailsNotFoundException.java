package com.nitienit.cards.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardDetailsNotFoundException extends RuntimeException {
    public CardDetailsNotFoundException(String message) {
        super(message);
        log.info("CardDetailsNotFoundException raised");
    }
}
