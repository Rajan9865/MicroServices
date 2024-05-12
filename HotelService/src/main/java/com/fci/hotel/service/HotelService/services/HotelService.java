/**
 * 
 */
package com.fci.hotel.service.HotelService.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fci.hotel.service.HotelService.Enties.Hotel;

/**
 * @author deby7 7:44:59 am 2023 HotelService TODO
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
