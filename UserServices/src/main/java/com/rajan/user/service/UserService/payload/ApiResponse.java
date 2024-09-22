/**
 * 
 */
package com.rajan.user.service.UserService.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan kumar 12:02:37 am 2023 UserService TODO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;

}
