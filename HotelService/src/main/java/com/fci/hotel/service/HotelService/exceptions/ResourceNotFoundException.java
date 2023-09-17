/**
 * 
 */
package com.fci.hotel.service.HotelService.exceptions;

/**
 * @author deby7
 *7:57:58 am
 *2023
 *HotelService
 *TODO
 */
public class ResourceNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String s)
	{
		super(s);
	}
	public ResourceNotFoundException()
	{
		super("Resource not found !@!");
	}
}
