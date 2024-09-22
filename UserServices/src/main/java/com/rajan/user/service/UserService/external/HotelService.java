/**
 * 
 */
package com.rajan.user.service.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rajan.user.service.UserService.entities.Hotel;

/**
 * com.fci.user.service.UserService.external DelL
 * @author Rajan kumar
 */
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
