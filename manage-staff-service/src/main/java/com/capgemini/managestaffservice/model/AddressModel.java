package com.capgemini.managestaffservice.model;

import javax.validation.constraints.*;

public class AddressModel {
	@NotNull
	private int Id;

	@NotBlank(message = "streetname is mandatory")
	@Size(min = 5, max = 120, message = "street cannot be less than 5 and more than 120 alphabets")
	private String streetName;

	@Size(min = 2, max = 7, message = "houseNo cannot be less than 4 and more than 7 alphabets")
	private String houseNo;

	@NotBlank(message = "city is mandatory")
	@Size(min = 3, max = 20, message = "city cannot be less than 3 and more than 20 alphabets")
	private String city;

	@NotBlank(message = "state is mandatory")
	@Size(min = 2, max = 20, message = "state cannot be less than 2 and more than 20 alphabets")
	private String state;

	@NotBlank(message = "country is mandatory")
	@Size(min = 3, max = 20, message = "country cannot be less than 3 and more than 20 alphabets")
	private String country;

	@NotNull(message = "pincode is mandatory")
	@Min(value = 100001)
	@Max(value = 999999)
	private long pincode;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
