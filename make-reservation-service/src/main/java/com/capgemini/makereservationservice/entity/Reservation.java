package com.capgemini.makereservationservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReservationData")
public class Reservation {
	@Id
	private int code;
	private int noOfChildren;
	private int noOfAdult;
	private Date checkIn;
	private Date checkOut;
	private String status;
	private int noOfNight;
	private int roomNo;
	private String guestEmail;
	private long guestPhoneNo;
	
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
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
