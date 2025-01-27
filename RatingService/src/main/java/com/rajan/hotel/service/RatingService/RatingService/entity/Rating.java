/**
 * 
 */
package com.rajan.hotel.service.RatingService.RatingService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan kumar 6:54:18 am 2023 RatingService TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_rating")
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;

}
