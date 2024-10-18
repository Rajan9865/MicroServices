/**
 * 
 */
package com.rajan.hotel.service.RatingService.RatingService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rajan.hotel.service.RatingService.RatingService.entity.Rating;

/**
 * @author Rajan kumar 7:04:07 am 2023 RatingService TODO
 */
public interface RatingRepository extends MongoRepository<Rating, String> {

	// custom find methods
	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String hotelId);
}
