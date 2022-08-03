package com.capgemini.manageinventoryservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.capgemini.manageinventoryservice.entity.Inventory;
import com.capgemini.manageinventoryservice.model.InventoryModel;

@Component
public class InventoryMapper {

	public Inventory mapDtoToEnttity(InventoryModel inventory) {

		Inventory inventoryEntity = new Inventory();
		inventoryEntity.setId(inventory.getId());
		inventoryEntity.setItemname(inventory.getItemname());
		inventoryEntity.setQuantity(inventory.getQuantity());
		return inventoryEntity;
	}

	public InventoryModel mapEntityToDto(Inventory inventory) {

		InventoryModel inventoryModel = new InventoryModel();
		BeanUtils.copyProperties(inventory, inventoryModel);
		return inventoryModel;

	}

}