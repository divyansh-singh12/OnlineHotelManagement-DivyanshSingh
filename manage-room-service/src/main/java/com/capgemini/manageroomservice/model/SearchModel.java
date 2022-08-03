package com.capgemini.manageroomservice.model;

import java.util.Date;

public class SearchModel {
	private String type;
	private Date check_in;
	private int no_of_guest;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public int getNo_of_guest() {
		return no_of_guest;
	}

	public void setNo_of_guest(int no_of_guest) {
		this.no_of_guest = no_of_guest;
	}

}
