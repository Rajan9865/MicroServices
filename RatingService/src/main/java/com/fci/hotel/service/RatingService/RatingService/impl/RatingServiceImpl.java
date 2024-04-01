/**
 * 
 */
package com.fci.hotel.service.RatingService.RatingService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fci.hotel.service.RatingService.RatingService.entity.Rating;
import com.fci.hotel.service.RatingService.RatingService.exception.RatingNotFoundException;
import com.fci.hotel.service.RatingService.RatingService.repository.RatingRepository;
import com.fci.hotel.service.RatingService.RatingService.services.RatingService;

/**
 * @author deby7 7:11:56 am 2023 RatingService TODO
 */
@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating>ratings=ratingRepository.findByUserId(userId);
		if (ratings.isEmpty()) {
			throw new RatingNotFoundException(userId);
		}
		return ratings;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
