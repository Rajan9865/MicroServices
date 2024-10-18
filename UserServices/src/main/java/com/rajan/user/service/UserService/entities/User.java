/**
 * 
 */
package com.fci.user.service.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan kumar 11:12:45 pm 2023 UserService TODO
 */
@Entity
@Table(name = "micro_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@Column(name = "ID")
	private String userId;

	@Column(name = "NAME", length = 20)
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ABOUT")
	private String about;

	// other user properties you can add here this
	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
