package com.nitienit.loans.controller;

import com.nitienit.loans.dto.LoanDto;
import com.nitienit.loans.service.ILoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/loan")
@Slf4j
public class LoanController {

    @Autowired
    private ILoanService iLoanService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public LoanDto createLoan(@RequestBody LoanDto loanDto) {
        log.info("LoanController :: createLoan");
        return iLoanService.createLoan(loanDto);
    }

    @GetMapping("/fetch/{contactNo}")
    public LoanDto fetchLoanDetails(@PathVariable String contactNo) {
        log.info("LoanController :: fetchLoanDetails contactNo{}", contactNo);
        return iLoanService.fetchLoanDetails(contactNo);
    }

    @PutMapping("/update")
    public LoanDto updateLoanDetails(@RequestBody LoanDto loanDto) {
        log.info("LoanController :: updateLoanDetails");
        return iLoanService.updateLoanDetails(loanDto);
    }

    @DeleteMapping("/delete/{loanNo}")
    public boolean deleteLoanDetails(@PathVariable String loanNo) {
        log.info("LoanController :: deleteLoanDetails");
        return iLoanService.deleteLoanDetails(loanNo);
    }

}
