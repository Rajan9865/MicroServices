/**
 * 
 */
package com.fci.hotel.service.RatingService.RatingService.services;

import java.util.List;

import com.fci.hotel.service.RatingService.RatingService.entity.Rating;

/**
 * @author deby7
 *7:06:23 am
 *2023
 *RatingService
 *TODO
 */
public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//get all rating
	List<Rating>getRatings();
	
	// get all by userid
	List<Rating>getRatingByUserId(String userId);
	
	// get all by hotel
	List<Rating>getRatingByHotelId(String hotelId);

}
