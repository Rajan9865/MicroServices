/**
 * 
 */
package com.rajan.hotel.service.HotelService.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rajan.hotel.service.HotelService.Enties.Hotel;
import com.rajan.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.rajan.hotel.service.HotelService.repositories.HotelRepository;
import com.rajan.hotel.service.HotelService.services.HotelService;

/**
 * @author Rajan kumar 7:49:31 am 2023 HotelService TODO
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
//		String hotelId = UUID.randomUUID().toString();
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!!"));
	}

	@Override
	public ResponseEntity<String> deleteById(String id) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
        	hotelRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Hotel with Id " + id + " deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found with this id " + id);
        }
	}

}
