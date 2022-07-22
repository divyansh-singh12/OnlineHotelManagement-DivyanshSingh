package com.capgemini.managestaffservice.model;

import java.util.Date;

public class StaffModel {
	private int  code;
	private String firstname;
	private String lastname;
	private int salary;
	private Date joinedon;
	private int age;
	private String occupation;
	private String email;
	private AddressModel address;
	
	public StaffModel() {
		super();
	}
	public StaffModel(int code, String firstname, String lastname, int salary, Date joinedon, int age,
			String occupation, String email, AddressModel address) {
		super();
		this.code = code;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.joinedon = joinedon;
		this.age = age;
		this.occupation = occupation;
		this.email = email;
		this.address = address;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getJoinedon() {
		return joinedon;
	}
	public void setJoinedon(Date joinedon) {
		this.joinedon = joinedon;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}
}
