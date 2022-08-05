package com.capgemini.manageinventoryservice.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

import com.capgemini.manageinventoryservice.MqConfig;
import com.capgemini.manageinventoryservice.model.CustomMessage;
import com.capgemini.manageinventoryservice.model.InventoryModel;
import com.capgemini.manageinventoryservice.service.InventoryService;

@RestController
@RequestMapping("/ManageInventory")
public class InventoryController {
	Logger logger = LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private RabbitTemplate template;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello test has been accessed");
		return ResponseEntity.ok("Hello World 2");
	}

	@PostMapping(value = "/addinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> addInvent(@RequestBody InventoryModel inventory) {
		InventoryModel model = inventoryService.addInvent(inventory);

		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append(model.getQuantity()).append(" ").append(model.getItemname())
				.append(" has been added to the Inventory ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);
		logger.info("Add inventory has been accessed");
		return ResponseEntity.ok(model);
	}

	@PutMapping(value = "/updateinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> updateInvent(@RequestBody InventoryModel inventory) {
		InventoryModel model = inventoryService.updateInvent(inventory);
		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append(model.getItemname()).append(" with ").append(model.getQuantity())
				.append(" quantity has been updated in the Inventory ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);
		logger.info("Update inventory has been accessed");
		return ResponseEntity.ok(model);
	}

	@DeleteMapping(value = "/deleteinventory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteInvent(@PathVariable int id) {
		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append("Item with ").append(id).append(" as item id has been deleted from the Inventory ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);
		logger.info("Delete inventory has been accessed");
		return ResponseEntity.ok(inventoryService.deleteInvent(id));
	}

	@GetMapping(value = "/viewinventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryModel> findInventByName(@RequestBody InventoryModel inventory) {
		logger.info("View inventory by name has been accessed");
		return ResponseEntity.ok(inventoryService.viewInventByName(inventory.getItemname()));
	}

	@GetMapping(value = "/viewall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryModel>> viewAll() {
		logger.info("View all inventory has been accessed");
		return ResponseEntity.ok(inventoryService.viewAll());

	}

}