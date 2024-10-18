/**
 * 
 */
package com.fci.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan kumar 7:56:28 pm 2024 UserService TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	private String id;
	private String name;
	private String location;
	private String about;

}
