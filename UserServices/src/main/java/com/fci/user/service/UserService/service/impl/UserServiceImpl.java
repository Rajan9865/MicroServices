/**
 * 
 */
package com.fci.user.service.UserService.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.fci.user.service.UserService.external.HotelService;
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

	@Autowired
    private HotelService hotelService;
	
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
//	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		// get user from database with the help of repository
		User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		// fetching rating of the above user from rating service
		log.info("feign client ..........");
		// http://localhost:8081/users/47ff61a9-aa79-4932-9513-b87960a55f92
		Rating[] ratingOfUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
		log.info("response feignclient ");
		log.info(" {}  ",ratingOfUser);
		List<Rating> ratings = Arrays.asList(ratingOfUser);
        List<Rating> ratingList = ratings.stream().map(rating -> {
			// api to call hotel service to get the hotel
			//localhost:8082/hotels/daedb1ab-8ea5-487d-bd3a-46d178cffa48
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
//			Hotel hotel = forEntity.getBody();
        	Hotel hotel = hotelService.getHotel(rating.getHotelId());
//			log.info("response status code {} ",forEntity.getStatusCode());
			//set the hotel to rating
			rating.setHotel(hotel);
			//return the rating
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}

}
