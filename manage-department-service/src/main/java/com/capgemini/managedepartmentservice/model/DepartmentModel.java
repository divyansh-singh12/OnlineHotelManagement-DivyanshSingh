package com.capgemini.managedepartmentservice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DepartmentModel {

	@NotNull(message = "can't be null")
	private int id;

	@NotBlank(message = "name is mandatory")
	@Size(min = 3, max = 14, message = "criteria does not match")
	private String name;

	@NotBlank(message = "hod name is mandatory")
	@Size(min = 3, max = 14)
	private String hodName;

	@NotBlank(message = "phone no can not be null")
	@Pattern(regexp = "^(\\s*|\\d{10})$", message = "criteria doesn't match")
	private String hodPhoneNo;

	@NotNull(message = "can't be null")
	@Min(value = 2)
	@Max(value = 40)
	private int sizeOfDepartment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getHodPhoneNo() {
		return hodPhoneNo;
	}

	public void setHodPhoneNo(String hodPhoneNo) {
		this.hodPhoneNo = hodPhoneNo;
	}

	public int getSizeOfDepartment() {
		return sizeOfDepartment;
	}

	public void setSizeOfDepartment(int sizeOfDepartment) {
		this.sizeOfDepartment = sizeOfDepartment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
