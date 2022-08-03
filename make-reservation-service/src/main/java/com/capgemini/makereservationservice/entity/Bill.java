package com.capgemini.makereservationservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BillData")
public class Bill {

	@Id
	private int billid;
	private String guestName;
	private String guestEmail;
	private int roomno;
	private String roomType;
	private Date billDate;
	private int days;
	private int rate;
	private int extensiondays;
	private int extensionMoney;
	private int tax = 18;
	private double totalBill;

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

	public int getExtensiondays() {
		return extensiondays;
	}

	public void setExtensiondays(int extensiondays) {
		this.extensiondays = extensiondays;
	}

	public int getExtensionMoney() {
		return extensionMoney;
	}

	public void setExtensionMoney(int extensionMoney) {
		this.extensionMoney = extensionMoney;
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
}
