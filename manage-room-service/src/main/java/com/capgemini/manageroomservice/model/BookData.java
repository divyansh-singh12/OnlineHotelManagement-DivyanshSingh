package com.capgemini.manageroomservice.model;

import java.util.Date;

public class BookData {
	private int roomNo;
	private Date bookedTill;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Date getBookedTill() {
		return bookedTill;
	}

	public void setBookedTill(Date bookedTill) {
		this.bookedTill = bookedTill;
	}

}
