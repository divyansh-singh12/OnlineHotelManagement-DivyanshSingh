package com.capgemini.manageuserservice.model;

import javax.validation.constraints.*;

public class UserModel {

	@NotBlank
	@Pattern(regexp = "^(\\s*|\\d{10})$", message = "criteria doesn't match")
	private String username;
	@NotBlank
	private String name;
	@NotBlank
	@Size(min = 6, max = 12)
	private String password;
	@NotBlank
	private String role;

	public UserModel() {

	}

	public UserModel(String username, String name, String password, String role) {

		this.username = username;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public UserModel(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}