package com.capgemini.manageinventoryservice.model;

public class InventoryModel {
	
	
	private int id;
	private String itemname;
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
