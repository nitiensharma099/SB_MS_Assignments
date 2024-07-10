package com.nitienit.loans.repository;

import com.nitienit.loans.dto.LoanDto;
import com.nitienit.loans.entites.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByLoanNo(String loanNo);

    Optional<Loan> findByContactNo(String contactNo);

    void deleteByContactNo(String contactNo);
}
