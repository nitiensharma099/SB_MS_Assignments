package com.nitienit.loans.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    private Long loanId;
    private String loanNo;
    private String loanType;
    private String contactNo;
    private int totalLoan;
    private int amountPaid;
    private int outStandingAmount;

}