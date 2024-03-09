/**
 * 
 */
package com.fci.user.service.UserService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fci.user.service.UserService.entities.User;
import com.fci.user.service.UserService.exceptions.ResourceNotFoundException;
import com.fci.user.service.UserService.reposiories.UserRepository;
import com.fci.user.service.UserService.service.UserService;

/**
 * @author deby7
 *11:35:49 pm
 *2023
 *UserService
 *TODO
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		//generate unique userId
		/*
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
		*/
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}
 
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	// get single user
	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository
		 User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! "+userId));
		 // fetch rating Of the above user from RATING SERVICE
		 // localhost:8083/ratings/users/f2214aa0-76e1-46b6-988e-28f34716b570
		 
		 return user;
	}

}














