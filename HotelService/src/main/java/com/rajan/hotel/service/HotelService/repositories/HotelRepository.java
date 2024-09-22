/**
 * 
 */
package com.rajan.hotel.service.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajan.hotel.service.HotelService.Enties.Hotel;

/**
 * @author Rajan kumar 7:42:55 am 2023 HotelService TODO
 */
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
