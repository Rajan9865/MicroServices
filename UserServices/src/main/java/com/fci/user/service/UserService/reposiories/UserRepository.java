/**
 * 
 */
package com.fci.user.service.UserService.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.user.service.UserService.entities.User;

/**
 * @author Rajan.kumar
 *11:18:37 pm
 *2023
 *UserService
 *TODO
 */
public interface UserRepository extends JpaRepository<User, String>{
	
	// if you want to implement  any custom method or query 
	// write to free	

}
