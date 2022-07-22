package com.capgemini.manageinventoryservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageinventoryservice.model.InventoryModel;
import com.capgemini.manageinventoryservice.service.InventoryService;

@RestController
@RequestMapping("ManageInventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
			return ResponseEntity.ok("Hello World 2");
	}
	
	@PostMapping(value = "/addinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> addInvent(@RequestBody InventoryModel inventory) {
		return ResponseEntity.ok(inventoryService.addInvent(inventory));
	}
	
	@PutMapping(value="/updateinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> updateInvent(@RequestBody InventoryModel inventory){
		return ResponseEntity.ok(inventoryService.updateInvent(inventory));
	}
	
	@DeleteMapping(value = "/deleteinventory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteInvent(@PathVariable int id) {
		return ResponseEntity.ok(inventoryService.deleteInvent(id));
	}
	
	@GetMapping(value = "/viewinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> findInventByName(@RequestBody InventoryModel inventory) {
		return ResponseEntity.ok(inventoryService.viewInventByName(inventory.getItemname()));
		
	}
	@GetMapping(value = "/viewall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<InventoryModel>> viewAll() {
		return ResponseEntity.ok(inventoryService.viewAll());
		
	}
	
}