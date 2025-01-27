/**
 * 
 */
package com.rajan.user.service.UserService.service;

import java.util.List;

import com.rajan.user.service.UserService.entities.User;

/**
 * @author Rajan kumar 11:22:41 pm 2023 UserService TODO
 */
public interface UserService {

	// user operations

	// create
	User saveUser(User user);

	// get all user
	List<User> getAllUser();

	// get single user of given userId
	User getUser(String userId);

	// TODO:delete
	void deleteUser(Integer userId);
	// TODO:update

}
