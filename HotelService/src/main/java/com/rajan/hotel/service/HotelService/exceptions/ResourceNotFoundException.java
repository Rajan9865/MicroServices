/**
 * 
 */
package com.rajan.hotel.service.HotelService.exceptions;

/**
 * @author Rajan kumar 7:57:58 am 2023 HotelService TODO
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String s) {
		super(s);
	}

	public ResourceNotFoundException() {
		super("Resource not found !@!");
	}
}
