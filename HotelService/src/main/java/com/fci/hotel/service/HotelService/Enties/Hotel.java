/**
 * 
 */
package com.fci.hotel.service.HotelService.Enties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author deby7 10:20:11 pm 2023 HotelService TODO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
