package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
