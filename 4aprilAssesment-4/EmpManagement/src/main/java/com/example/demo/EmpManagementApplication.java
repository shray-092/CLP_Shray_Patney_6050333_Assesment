package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.EmpRepository;
import com.example.demo.entity.Emp;

@SpringBootApplication
public class EmpManagementApplication implements CommandLineRunner {
	@Autowired
	private EmpRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(EmpManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Emp e1 = new Emp();
	        e1.setEmpName("John Doe");
	        e1.setEmpSal(50000.0);
	        e1.setEmpDoj(LocalDate.of(2026, 4, 15));
	        e1.setDeptName("IT");

	        Emp e2 = new Emp();
	        e2.setEmpName("Jane Smith");
	        e2.setEmpSal(60000.0);
	        e2.setEmpDoj(LocalDate.of(2027, 7, 10));
	        e2.setDeptName("HR");

	        repo.save(e1);
	        repo.save(e2);
		
	}

}
