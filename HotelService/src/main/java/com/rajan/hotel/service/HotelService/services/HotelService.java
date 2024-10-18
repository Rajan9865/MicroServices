/**
 * 
 */
package com.rajan.hotel.service.HotelService.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rajan.hotel.service.HotelService.Enties.Hotel;

/**
 * @author Rajan kumar 7:44:59 am 2023 HotelService TODO
 */
public interface HotelService {

	// create
	Hotel create(Hotel hotel);

	// get all
	List<Hotel> getAll();

	// get single
	Hotel get(String id);
	// delete by ID
	ResponseEntity<String> deleteById(String id);

}
