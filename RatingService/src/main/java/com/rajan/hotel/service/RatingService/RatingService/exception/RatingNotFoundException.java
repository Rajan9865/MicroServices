/**
 * 
 */
package com.rajan.hotel.service.RatingService.RatingService.exception;

/**
 * @author Rajan kumar
 *10:38:12 am
 *2024
 *RatingService
 *TODO
 */
public class RatingNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RatingNotFoundException(String userId)
	{
		super("No ratings found for user Id: "+userId);
	}

}
