package com.capgemini.managedepartmentservice.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "departmentdetails")
public class Department {
	
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String hodName;
	@Column
	private long hodPhoneNo;
	@Column
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
	public long getHodPhoneNo() {
		return hodPhoneNo;
	}
	public void setHodPhoneNo(long hodPhoneNo) {
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