package com.deepak.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.deepak.model.UserDetail;

public class UserInfoUserDetail implements UserDetails {

	// getting userdetail(model class) information and converting to UserDetails understand by spring security
	
	private String username;
	private String pwd;
	private List<GrantedAuthority> authorities;
	
	public UserInfoUserDetail(UserDetail user)
	
	{
		//mapping userdetail(model) class with UserDetail column fields
		username=user.getName();
		pwd=user.getPassword();
		
		System.out.print("Name :"+user.getName() + "Pass :"+user.getPassword());
		
		//we can assign multiple roles to a single user but it is better to extract the roles,split them
		
		authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
