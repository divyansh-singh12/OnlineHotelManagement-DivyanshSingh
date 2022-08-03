package com.capgemini.manageinventoryservice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InventoryModel {

	@NotNull
	private int id;
	@NotBlank(message = "itemname is mandatory")
	private String itemname;
	@NotNull(message = "quantity is mandatory")
	@Min(value = 1, message = "quantity cannnot  be less than 1")
	@Max(value = 100, message = "quantity cannnot  be more than 100")
	private int quantity;

	public InventoryModel() {

	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
