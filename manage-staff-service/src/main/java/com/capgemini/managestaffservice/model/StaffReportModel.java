package com.capgemini.managestaffservice.model;

import java.util.Date;

public class StaffReportModel {
	private int code;
	private String firstname;
	private String lastname;
	private int salary;
	private Date joinedon;

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

}
