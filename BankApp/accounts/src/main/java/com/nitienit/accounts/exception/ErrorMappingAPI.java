package com.nitienit.accounts.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMappingAPI {
    private String errorStatus;
    private String errorMessage;
    private LocalDateTime errorDateTime;
}
