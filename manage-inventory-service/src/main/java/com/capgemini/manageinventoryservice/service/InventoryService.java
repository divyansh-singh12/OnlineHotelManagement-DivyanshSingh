package com.capgemini.manageinventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.manageinventoryservice.model.InventoryModel;

@Service
public interface InventoryService {
	public InventoryModel addInvent(InventoryModel inventory);
	public InventoryModel updateInvent(InventoryModel inventory);
	public String deleteInvent(int id);
	
	
	
	public List<InventoryModel> viewAll();
	public InventoryModel viewInventByName(String itemname);

}
