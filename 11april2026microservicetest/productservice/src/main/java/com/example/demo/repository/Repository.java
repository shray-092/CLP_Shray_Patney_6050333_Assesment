package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Product.Product;

public interface Repository extends JpaRepository<Product, Long> {
	

}
