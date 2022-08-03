package com.capgemini.makereservationservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BillModel {
	private int billid;
	private String guestName;
	private String guestEmail;
	private int roomno;
	private String roomType;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date billDate;
	private int days;
	private int rate;
	private int extensiondays;
	private int extensionRate;
	private int tax = 18;
	private double totalBill;

	public BillModel() {
		super();
	}

	public BillModel(int billid, String guestName, String guestEmail, int roomno, String roomType, Date billDate,
			int days, int rate, int tax, double totalBill) {
		super();
		this.billid = billid;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.roomno = roomno;
		this.roomType = roomType;
		this.billDate = billDate;
		this.days = days;
		this.rate = rate;
		this.tax = tax;
		this.totalBill = totalBill;
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billId) {
		this.billid = billId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomNo) {
		this.roomno = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public int getExtensiondays() {
		return extensiondays;
	}

	public void setExtensiondays(int extensiondays) {
		this.extensiondays = extensiondays;
	}

	public int getExtensionRate() {
		return extensionRate;
	}

	public void setExtensionRate(int extensionMoney) {
		this.extensionRate = extensionMoney;
	}

}
