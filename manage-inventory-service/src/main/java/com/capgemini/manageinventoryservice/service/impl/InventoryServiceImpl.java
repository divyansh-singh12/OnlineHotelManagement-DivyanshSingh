package com.capgemini.manageinventoryservice.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageinventoryservice.entity.Inventory;
import com.capgemini.manageinventoryservice.mapper.InventoryMapper;
import com.capgemini.manageinventoryservice.model.InventoryModel;
import com.capgemini.manageinventoryservice.repository.InventoryRepository;
import com.capgemini.manageinventoryservice.service.InventoryService;

@Component
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryMapper inventoryMapper;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public InventoryModel addInvent ( InventoryModel inventory) {
		
		Inventory roomEntity= inventoryRepository.save(inventoryMapper.mapDtoToEnttity(inventory));
		return inventoryMapper.mapEntityToDto(roomEntity);
	}
	
	public InventoryModel updateInvent (InventoryModel inventory) {
		
		Inventory inventoryEntity = inventoryRepository.findById(inventory.getId());
		inventoryEntity.setItemname(inventory.getItemname());
		inventoryEntity.setQuantity (inventory.getQuantity());
		inventoryEntity = inventoryRepository.save(inventoryEntity);
		return inventoryMapper.mapEntityToDto(inventoryEntity);		
	}
	
	public String deleteInvent ( int Id) {
		
		try {
			inventoryRepository.deleteById(Id);
			return "Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't delete";
	}
	
	public InventoryModel viewInventByName(String itemname) {
		Inventory inventoryEntity =inventoryRepository.findByItemname(itemname);
		return inventoryMapper.mapEntityToDto(inventoryEntity);
	}
	public List<InventoryModel> viewAll(){
		List<Inventory> inventoryList= inventoryRepository.findAll();
		List<InventoryModel> modelList= new ArrayList<InventoryModel>();
		for(Inventory inventory: inventoryList) {
			modelList.add(inventoryMapper.mapEntityToDto(inventory));
		}
		return modelList;
	}
	
}
