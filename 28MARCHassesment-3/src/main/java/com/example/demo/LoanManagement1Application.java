package com.example.demo;

import com.example.demo.entity.Loan;
import com.example.demo.repository.Loanrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanManagement1Application implements CommandLineRunner {

	@Autowired
	Loanrepository loanRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoanManagement1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Loan loan1 = new Loan(null,"Rahul Kumar", 250000, "PENDING");
		Loan loan2 = new Loan(null,"Priya Sharma", 100000, "APPROVED");
		Loan loan3 = new Loan(null,"Amit Singh", 500000, "REJECTED");

		loanRepository.save(loan1);
		loanRepository.save(loan2);
		loanRepository.save(loan3);

		System.out.println("data inserted successfully");
	}
}