package com.ems.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.dto.LoginRequest;
import com.ems.dto.RegisterRequest;
import com.ems.entity.User;
import com.ems.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public String register(RegisterRequest request)
	{
		if(userRepository.findByUsername(request.getUsername()).isPresent())
		{
			return "Username already exists";
		}
		
		User user = new User();
		
		user.setUsername(request.getUsername());
		
		user.setEmail(request.getEmail());
		
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		
		return "User Registered Successfully";
		
	}
	
	public String login(LoginRequest request)
	{
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("User not Found"));
		
		boolean matches = passwordEncoder.matches(
				request.getPassword(), 
				user.getPassword()
				);
		
		if(!matches)
			return "Invalid credentials";
		return "Login successful";
	}
	
	

}
