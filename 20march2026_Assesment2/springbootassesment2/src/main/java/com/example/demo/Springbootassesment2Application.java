package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Track;
import com.example.demo.repository.Trackrepository;

@SpringBootApplication
public class Springbootassesment2Application implements CommandLineRunner {
	
	@Autowired
	Trackrepository train;

	public static void main(String[] args) {
		SpringApplication.run(Springbootassesment2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Track t=new Track("Track1","Album1",LocalDate.of(2020, 1, 1));
		Track t1=new Track("Track2","Album2",LocalDate.of(2021, 2, 2));
		train.save(t);
		train.save(t1);
		
		
		
	}

}
