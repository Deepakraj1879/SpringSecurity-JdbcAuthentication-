package com.deepak.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.deepak.model.UserDetail;
import com.deepak.repo.User_repository;

@Component
public class UserDetailUserService implements UserDetailsService {

	//to get user detail object  we are autowiring user_repository
	@Autowired
	private User_repository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// loading the user's username from database so autowire repository ex:- form login where it is accepting database username and password
	 Optional<UserDetail> user=repository.findByName(username);
	
	 // converting userdetail object to UserDetails
	 // new is calling constructor
	return user.map(UserInfoUserDetail::new) 
	 .orElseThrow(()->new UsernameNotFoundException("user not found "+username));
	 
	}

}
