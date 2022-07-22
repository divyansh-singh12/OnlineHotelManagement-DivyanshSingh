package com.capgemini.managestaffservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@EntityScan
@Table(name = "staffdetails")
public class Staff {
	@Id
	@Column
	private int code;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private int salary;
	@Column
	private Date joinedon;
	@Column
	private int age;
	@Column
	private String occupation;
	@Column
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressid", referencedColumnName = "id")
	private Address address;
	
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
