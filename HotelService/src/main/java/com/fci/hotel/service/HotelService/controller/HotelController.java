/**
 * 
 */
package com.fci.hotel.service.HotelService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.hotel.service.HotelService.Enties.Hotel;
import com.fci.hotel.service.HotelService.repositories.HotelRepository;
import com.fci.hotel.service.HotelService.services.HotelService;

/**
 * @author deby7
 *8:23:08 am
 *2023
 *HotelService
 *TODO
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HotelRepository hotelRepository;

	// create

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}

	// Get single
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getId(@PathVariable String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll() {
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	// delete single records
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteHotel(@PathVariable String id)
	{
		return hotelService.deleteById(id);
	}
}
