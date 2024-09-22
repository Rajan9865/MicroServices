/**
 * 
 */
package com.rajan.hotel.service.HotelService.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Rajan kumar 8:37:39 am 2023 HotelService TODO
 */

@RestControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException exception) {
		 Map<String, Object> response = new HashMap<>();
		    response.put("message", exception.getMessage());
		    response.put("success", false);
		    response.put("status", HttpStatus.NOT_FOUND);
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
