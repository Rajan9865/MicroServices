/**
 * 
 */
package com.fci.hotel.service.HotelService.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fci.hotel.service.HotelService.Enties.Hotel;
import com.fci.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.fci.hotel.service.HotelService.repositories.HotelRepository;
import com.fci.hotel.service.HotelService.services.HotelService;

/**
 * @author deby7 7:49:31 am 2023 HotelService TODO
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

}
