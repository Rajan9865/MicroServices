/**
 * 
 */
package com.fci.user.service.UserService.exceptions;

/**
 * @author deby7
 *11:42:15 pm
 *2023
 *UserService
 *TODO
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//extra properties that you want to manage code
	public ResourceNotFoundException()
	{
		super("Resource not ffound on server");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
}
