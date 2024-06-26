/**
 * 
 */
package com.fci.user.service.UserService.Controller;

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

import com.fci.user.service.UserService.entities.User;
import com.fci.user.service.UserService.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author deby7 7:11:58 am 2023 UserService TODO
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
		log.info("user create succecessfully {}",user.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	// single user get
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
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
