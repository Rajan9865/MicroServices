/**
 * 
 */
package com.rajan.user.service.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.user.service.UserService.entities.User;
import com.rajan.user.service.UserService.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rajan kumar 7:11:58 am 2023 UserService TODO
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	// create
	/**
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("user create succecessfully {}", user.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	// single user get
	/**
	 * 
	 * @param userId
	 * @return
	 */
//	int retryCount=1;

//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
//		log.info("Retry count : {}",retryCount);
//		retryCount++;
		log.info("hello users ...................");
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	// Creating fall back methods for circuitBreacker
	public ResponseEntity<User> ratingHotelFallback(String userid, Exception ex) {
		log.info(" fallBack is executed because service is down :", ex.getMessage());
		ex.printStackTrace();
		User user = User.builder().email("rajan@gmail.com").name("Rajan kumar")
				.about("this user is created dummy because some service is down").userId("12713t17").build();
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	}

	// get all users
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
