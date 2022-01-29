package com.caramel.apple.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://benjaminjbonnet01.s3-website-us-east-1.amazonaws.com") 
public class UserJPAResource {
  
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<Users> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/users/register")
	public Users createUser(@RequestBody Users user) {
		Users savedUser = userRepository.save(user);
		return savedUser;
		
	}
	
	@PostMapping("/users/login")
	public ResponseEntity userLogin(@RequestBody Users user) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String usernameJs =user.getUsername();
		String passwordJs = user.getPassword();
		List<Users> loggedInUser = userRepository.findByUsername(usernameJs);
		for(Users u: loggedInUser) {
			if(passwordJs.equals(u.getPassword())) {
				status = HttpStatus.OK;
			}else {
				status = HttpStatus.UNAUTHORIZED;
			   	
			}
		}
		return ResponseEntity(status);
		
	
	
}

	private ResponseEntity ResponseEntity(HttpStatus status) {
		// TODO Auto-generated method stub
		return null;
	}
}