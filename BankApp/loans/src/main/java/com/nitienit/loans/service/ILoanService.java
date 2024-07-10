package com.nitienit.loans.service;

import com.nitienit.loans.dto.LoanDto;

public interface ILoanService {

    LoanDto createLoan(LoanDto loanDto);

    LoanDto fetchLoanDetails(String loanNo);

    LoanDto updateLoanDetails(LoanDto loanDto);

    boolean deleteLoanDetails(String loanNo);
}
