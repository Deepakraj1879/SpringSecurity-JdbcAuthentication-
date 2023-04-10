package com.deepak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deepak.model.UserDetail;
import com.deepak.repo.User_repository;

@Service
public class User_Service {
	
	@Autowired
	private User_repository userrepository;

    @Autowired
	private PasswordEncoder passwordEncoder;
    
    public String addUser(UserDetail user)
    {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    
    	userrepository.save(user);
    	return "user saved to database";
    }
	
}
