package com.capgemini.managestaffservice.controller;

import java.util.List;

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

import com.capgemini.managestaffservice.model.StaffList;
import com.capgemini.managestaffservice.model.StaffModel;
import com.capgemini.managestaffservice.service.StaffService;

@RestController
@RequestMapping("/ManageStaff")
public class StaffController {
	
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
			return ResponseEntity.ok("Hello World 3");
	}
	
	@PostMapping(value = "/addstaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> addStaff(@RequestBody StaffModel staff) {
		return ResponseEntity.ok(staffService.addStaffService(staff));
	}
	
	@PutMapping(value="/updatestaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> updateStaff(@RequestBody StaffModel staff){
		return ResponseEntity.ok(staffService.updateStaffService(staff));
	}
	
	@DeleteMapping(value = "/deletestaff",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteStaff(@RequestBody StaffModel staff) {
		return ResponseEntity.ok(staffService.deleteStaffService(staff.getCode()));
	}
	@GetMapping(value = "/viewstaff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StaffModel> viewStaffbyId(@RequestBody StaffModel staff) {
		return ResponseEntity.ok(staffService.viewStaffService(staff.getCode()));
	}
	@GetMapping(value = "/viewstaff", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<StaffModel>> viewAll() {
		return ResponseEntity.ok(staffService.viewAllList());
	}

	@GetMapping(value="/reportdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <StaffList> staffreport(){
		return ResponseEntity.ok(staffService.generateReport());
	}

}
