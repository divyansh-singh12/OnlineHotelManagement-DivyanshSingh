package com.capgemini.managedepartmentservice.model;

public class DepartmentModel {
	
	private int id;
	private String Name;
	private String hodName;
	private long hodPhoneNo;
	private int sizeOfDepartment;




	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
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