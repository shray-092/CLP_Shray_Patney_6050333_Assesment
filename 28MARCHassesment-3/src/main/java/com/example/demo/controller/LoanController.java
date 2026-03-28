package com.example.demo.controller;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

   
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan saved = loanService.createLoan(loan);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

   
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

 
    @PutMapping("/{id}/status")
    public ResponseEntity<Loan> updateStatus(@PathVariable Long id,
                                              @RequestBody Map<String, String> body) {
        String status = body.get("status");
        return ResponseEntity.ok(loanService.updateLoanStatus(id, status));
    }
}

