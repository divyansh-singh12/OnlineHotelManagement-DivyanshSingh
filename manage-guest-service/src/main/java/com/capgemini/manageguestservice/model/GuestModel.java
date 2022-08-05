package com.capgemini.manageguestservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class GuestModel {
	private int id;

	@NotBlank(message = "firstName is mandatory")
	private String firstName;

	@NotBlank(message = "LastName is mandatory")
	private String lastName;

	@NotBlank(message = "phoneno is mandatory")
	@Pattern(regexp = "^(\\s*|\\d{10})$", message = "criteria doesn't match")
	private String phoneNumber;

	@Size(min = 3, max = 20, message = "company cannot be less than 2 and more than 20 words")
	private String company;

	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "criteria doesnt match")
	private String email;

	@NotBlank
	private String gender;

	private AddressModel address;

	public GuestModel() {
		super();
	}

	public GuestModel(int id, String firstName, String lastName, AddressModel address, String phoneNumber,
			String company, String email, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.email = email;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}