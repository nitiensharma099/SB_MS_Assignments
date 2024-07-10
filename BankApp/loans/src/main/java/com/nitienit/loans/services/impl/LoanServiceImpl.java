package com.nitienit.loans.services.impl;

import com.nitienit.loans.dto.LoanDto;
import com.nitienit.loans.entites.Loan;
import com.nitienit.loans.exception.LoanRecordAlreadyPresentException;
import com.nitienit.loans.exception.LoanRecordNotFoundException;
import com.nitienit.loans.repository.LoanRepository;
import com.nitienit.loans.service.ILoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LoanServiceImpl implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        log.info("LoanServiceImpl :: createLoan {}", loanDto.getLoanNo());
        Optional<Loan> dbloan = loanRepository.findByLoanNo(loanDto.getLoanNo());
        if (dbloan.isEmpty()) {
            Loan loan = new Loan();
            BeanUtils.copyProperties(loanDto, loan);
            loanRepository.save(loan);
            Loan saveLoan = loanRepository.findByLoanNo(loanDto.getLoanNo()).orElseThrow(() -> new RuntimeException("No record found"));
            BeanUtils.copyProperties(saveLoan, loanDto);
        } else {
            throw new LoanRecordAlreadyPresentException("Record already present");
        }
        return loanDto;
    }

    @Override
    public LoanDto fetchLoanDetails(String contactNo) {
        log.info("LoanServiceImpl :: fetchLoanDetails contactNo ={}", contactNo);
        Loan loan = loanRepository.findByContactNo(contactNo).orElseThrow(() -> new LoanRecordNotFoundException("No record found with this contact No" + contactNo));

        LoanDto loanDto = new LoanDto();
        BeanUtils.copyProperties(loan, loanDto);

        return loanDto;
    }

    @Override
    public LoanDto updateLoanDetails(LoanDto loanDto) {
        log.info("LoanServiceImpl :: fetchLoanDetails updateLoanDetails ={}");
        Loan saveLoan = loanRepository.findByLoanNo(loanDto.getLoanNo()).orElseThrow(() -> new LoanRecordNotFoundException("No record found"));
        BeanUtils.copyProperties(loanDto, saveLoan);
        loanRepository.save(saveLoan);
        BeanUtils.copyProperties(saveLoan, loanDto);
        return loanDto;
    }

    @Override
    public boolean deleteLoanDetails(String contactNo) {
        log.info("LoanServiceImpl :: deleteLoanDetails contactNo ={}", contactNo);
        Loan loan = loanRepository.findByContactNo(contactNo).orElseThrow(() -> new LoanRecordNotFoundException("No record found with this contact No" + contactNo));
        loanRepository.deleteByContactNo(loan.getContactNo());
        return true;
    }
}
