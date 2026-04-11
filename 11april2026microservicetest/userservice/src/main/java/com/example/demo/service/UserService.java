package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.user.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	 public User getUserById(Long id) {
	        return userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }
	
	

}
