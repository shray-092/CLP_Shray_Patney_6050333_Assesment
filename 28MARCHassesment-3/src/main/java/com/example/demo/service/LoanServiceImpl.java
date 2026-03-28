package com.example.demo.service;

import com.example.demo.entity.Loan;
import com.example.demo.exception.*;

import com.example.demo.repository.Loanrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private Loanrepository loanRepository;

    @Override
    public Loan createLoan(Loan loan) {

      
        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
            throw new InvalidLoanAmountException(
                "Loan amount must be between 1 and 5000000"
            );
        }

     
        List<Loan> pendingLoans = loanRepository
            .findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING");

        if (!pendingLoans.isEmpty()) {
            throw new DuplicateLoanApplicationException(
                "Applicant already has a loan in PENDING status"
            );
        }

        loan.setStatus("PENDING");
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
            .orElseThrow(() -> new LoanNotFoundException(
                "Loan not found with ID: " + id
            ));
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {
        Loan loan = loanRepository.findById(id)
            .orElseThrow(() -> new LoanNotFoundException(
                "Loan not found with ID: " + id
            ));
        loan.setStatus(status);
        return loanRepository.save(loan);
    }
}
