package com.capgemini.manageroomservice.model;

import java.sql.Time;

public class RoomModel {
	private int room_no;
	private String type;
	private int capacity;
	private String status;
	private Time check_in_time;
	private Time check_out_time;
	private int room_rate;
	private int first_night_rate;
	private int extension_rate;
	
	public RoomModel() {
		
	}


	public RoomModel(String type, int capacity, Time check_in_time, Time check_out_time, int first_night_rate,
			int extension_rate) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
		this.first_night_rate = first_night_rate;
		this.extension_rate = extension_rate;
	}


	public RoomModel(int room_no, String type, int capacity, String status, int room_rate) {
		super();
		this.room_no = room_no;
		this.type = type;
		this.capacity = capacity;
		this.status = status;
		this.room_rate = room_rate;
	}


	public RoomModel(int room_no, String type, int capacity, String status) {
		super();
		this.room_no = room_no;
		this.type = type;
		this.capacity = capacity;
		this.status = status;
	}


	public Time getCheck_in_time() {
		return check_in_time;
	}


	public void setCheck_in_time(Time check_in_time) {
		this.check_in_time = check_in_time;
	}


	public Time getCheck_out_time() {
		return check_out_time;
	}


	public void setCheck_out_time(Time check_out_time) {
		this.check_out_time = check_out_time;
	}


	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRoom_rate() {
		return room_rate;
	}
	public void setRoom_rate(int room_rate) {
		this.room_rate = room_rate;
	}
	public int getFirst_night_rate() {
		return first_night_rate;
	}
	public void setFirst_night_rate(int first_night_rate) {
		this.first_night_rate = first_night_rate;
	}
	public int getExtension_rate() {
		return extension_rate;
	}
	public void setExtension_rate(int extension_rate) {
		this.extension_rate = extension_rate;
	}
	
	
}
