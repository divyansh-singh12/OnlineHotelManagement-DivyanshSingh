package com.capgemini.makereservationservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationModel {
	private int code;
	private int noOfChildren;
	private int noOfAdult;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date checkIn;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date checkOut;
	private String status;
	private int noOfNight;
	private int roomno;
	private String guestEmail;
	private long guestPhoneNo;
	
	public ReservationModel() {
		super();
	}
	public ReservationModel(int code, int noOfChildren, int noOfAdult, Date checkIn, Date checkOut, String status,
			int noOfNight, int roomno, String guestEmail, long guestPhoneNo) {
		super();
		this.code = code;
		this.noOfChildren = noOfChildren;
		this.noOfAdult = noOfAdult;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
		this.noOfNight = noOfNight;
		this.roomno = roomno;
		this.guestEmail = guestEmail;
		this.guestPhoneNo = guestPhoneNo;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public int getNoOfAdult() {
		return noOfAdult;
	}
	public void setNoOfAdult(int noOfAdult) {
		this.noOfAdult = noOfAdult;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoOfNight() {
		return noOfNight;
	}
	public void setNoOfNight(int noOfNight) {
		this.noOfNight = noOfNight;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomNo) {
		this.roomno = roomNo;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public long getGuestPhoneNo() {
		return guestPhoneNo;
	}
	public void setGuestPhoneNo(long guestPhoneNo) {
		this.guestPhoneNo = guestPhoneNo;
	}
	
	
}
