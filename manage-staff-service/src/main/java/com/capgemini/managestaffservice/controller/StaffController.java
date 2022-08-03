package com.capgemini.managestaffservice.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.managestaffservice.MqConfig;
import com.capgemini.managestaffservice.model.CustomMessage;
import com.capgemini.managestaffservice.model.StaffList;
import com.capgemini.managestaffservice.model.StaffModel;
import com.capgemini.managestaffservice.service.StaffService;

@RestController
@RequestMapping("/ManageStaff")
public class StaffController {

	Logger logger = LoggerFactory.getLogger(StaffController.class);
	@Autowired
	private RabbitTemplate template;

	@Autowired
	private StaffService staffService;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello Test has been accessed");
		return ResponseEntity.ok("Hello World 3");
	}

	@PostMapping(value = "/addstaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> addStaff(@RequestBody StaffModel staff) {
		StaffModel model = staffService.addStaffService(staff);

		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append(model.getFirstname()).append(" ").append(model.getLastname()).append(" with staff id as ")
				.append(model.getCode()).append(" has been added to the staff ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);

		logger.info("Add staff has been accessed");
		return ResponseEntity.ok(model);
	}

	@PutMapping(value = "/updatestaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> updateStaff(@RequestBody StaffModel staff) {
		StaffModel model = staffService.updateStaffService(staff);

		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append(model.getFirstname()).append(" ").append(model.getLastname()).append(" with staff id as ")
				.append(model.getCode()).append(" has updated the details in the staff ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);

		logger.info("Update staff has been accessed");
		return ResponseEntity.ok(model);
	}

	@DeleteMapping(value = "/deletestaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteStaff(@RequestBody StaffModel staff) {
		CustomMessage message = new CustomMessage();

		StringBuilder str = new StringBuilder();
		str.append("Staff with staff id as ").append(staff.getCode())
				.append(" has left the job and the details in the DB are deleted ");

		message.setMessage(str.toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTING_KEY, message);

		logger.info("delete staff has been accessed");
		return ResponseEntity.ok(staffService.deleteStaffService(staff.getCode()));
	}

	@GetMapping(value = "/viewstaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> viewStaffbyId(@RequestBody StaffModel staff) {
		logger.info("view staff by code has been accessed");
		return ResponseEntity.ok(staffService.viewStaffService(staff.getCode()));
	}

	@GetMapping(value = "/viewstaff", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StaffModel>> viewAll() {
		logger.info("View all staff has been accessed");
		return ResponseEntity.ok(staffService.viewAllList());
	}

	@GetMapping(value = "/reportdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffList> staffreport() {
		logger.info("report staff data has been accessed");
		return ResponseEntity.ok(staffService.generateReport());
	}

}
