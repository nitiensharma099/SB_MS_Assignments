package com.nitienit.loans.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMappingAPI {
    private String errorStatus;
    private String errorMessage;
    private LocalDateTime errorDateTime;
}
