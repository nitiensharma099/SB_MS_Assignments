package com.nitienit.cards.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMappingApi {
    private String errorStatus;
    private String errorMessage;
    private LocalDateTime errorDateTime;
}
