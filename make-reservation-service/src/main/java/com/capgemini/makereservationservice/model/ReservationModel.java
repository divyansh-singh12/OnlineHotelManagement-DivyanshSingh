package com.capgemini.makereservationservice.model;

import java.util.Date;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationModel {

	private int code;
	@Min(value = 0)
	@Max(value = 4)
	private int noOfChildren;
	@Min(value = 1)
	@Max(value = 4)
	private int noOfAdult;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date checkIn;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date checkOut;
	@NotBlank
	private String status;
	@NotNull
	// no of nights can be 0.
	private int noOfNight;
	@NotNull
	private int roomno;
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "criteria doesnt match")
	private String guestEmail;
	@NotBlank(message = "phone no can not be null")
	@Pattern(regexp = "^(\\s*|\\d{10})$", message = "criteria doesn't match")
	private String guestPhoneNo;

	public ReservationModel() {
		super();
	}

	public ReservationModel(int code, int noOfChildren, int noOfAdult, Date checkIn, Date checkOut, String status,
			int noOfNight, int roomno, String guestEmail, String guestPhoneNo) {
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

	public String getGuestPhoneNo() {
		return guestPhoneNo;
	}

	public void setGuestPhoneNo(String guestPhoneNo) {
		this.guestPhoneNo = guestPhoneNo;
	}

}
