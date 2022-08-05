package com.capgemini.manageroomservice.model;

import java.sql.Time;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SetRatesModel {

	@NotBlank
	private String type;
	@NotNull
	@Min(value = 1)
	@Max(value = 6)
	private int capacity;
	@NotNull
	private Time check_in_time;
	@NotNull
	private Time check_out_time;
	@NotNull
	@Min(value = 500)
	@Max(value = 100000)
	private int first_night_rate;
	@NotNull
	@Min(value = 500)
	@Max(value = 100000)
	private int extension_rate;

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
