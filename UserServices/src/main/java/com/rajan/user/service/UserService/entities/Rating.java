/**
 * 
 */
package com.rajan.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan kumar 7:54:35 am 2023 UserService TODO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;

	private Hotel hotel;

}
