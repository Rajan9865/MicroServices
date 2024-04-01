/**
 * 
 */
package com.fci.user.service.UserService.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fci.user.service.UserService.entities.Hotel;
import com.fci.user.service.UserService.entities.Rating;
import com.fci.user.service.UserService.entities.User;
import com.fci.user.service.UserService.exceptions.ResourceNotFoundException;
import com.fci.user.service.UserService.payload.ApiResponse;
import com.fci.user.service.UserService.reposiories.UserRepository;
import com.fci.user.service.UserService.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author deby7 11:35:49 pm 2023 UserService TODO
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		// generate unique userId
		/*
		 * String randomUserId = UUID.randomUUID().toString();
		 * user.setUserId(randomUserId); return userRepository.save(user);
		 */
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// get single user
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !! " + userId));
		// fetch rating Of the above user from RATING SERVICE
		// localhost:8083/ratings/users/f2214aa0-76e1-46b6-988e-28f34716b570
//		@SuppressWarnings("unchecked")
//		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
//		log.info("Api calling.. {}",ratingsOfUser);
//		user.setRatings(ratingsOfUser);
//		return user;-

		try {
			ArrayList<Rating> ratingsOfUser = restTemplate
					.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
			log.info("API calling.. {}", ratingsOfUser);
			List<Rating>ratingList= ratingsOfUser.stream().map(rating->
			{
				// api call to hotel service to get the hotel
				// http://localhost:8082/hotels/d00d8a5e-8c26-4394-afd2-50cae7613f31
				ResponseEntity<Hotel>forEntity= restTemplate.getForEntity("http://localhost:8082/hotels/"rating.getHotelId(), Hotel.class);
				Hotel hotel=forEntity.getBody();
				log.info(" response status code :{}")
				// set the hotel to string
				// return the rating
				
			})
			
			user.setRatings(ratingsOfUser);
		} catch (ResourceAccessException e) {
			log.error("Error calling the ratings service: {}", e.getMessage());
			// Handle the exception or return a default response
			// For example, you might set a default value for ratings or return an error
			// message
			user.setRatings(Collections.emptyList()); // Set default empty list
		}
		return user;

	}

}
