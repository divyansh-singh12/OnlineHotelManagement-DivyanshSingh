package com.capgemini.managedepartmentservice.controller;

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

import com.capgemini.managedepartmentservice.model.DepartmentModel;
import com.capgemini.managedepartmentservice.service.DepartmentService;

@RestController
@RequestMapping("owner/ManageDepartment")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;


	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
			return ResponseEntity.ok("Hello World-1");
	}
	
	@PostMapping(value = "/adddepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentModel> addDepartment(@RequestBody DepartmentModel department) {
		return ResponseEntity.ok(departmentService.addDepartmentService(department));
	}
	
	@PutMapping(value="/updatedepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentModel> updateDepartment(@RequestBody DepartmentModel department){
		return ResponseEntity.ok(departmentService.updateDepartmentService(department));
	}
	
	@DeleteMapping(value = "/deletedepartment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
		return ResponseEntity.ok(departmentService.deleteDepartmentService(id));
	}
	 
		@GetMapping(value = "/viewdepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<DepartmentModel> findDepartmentByName(@RequestBody DepartmentModel department) {
			return ResponseEntity.ok(departmentService.viewDepartmentByName(department.getName()));
			
		}
		@GetMapping(value = "/viewall", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <List<DepartmentModel>> viewAll() {
			return ResponseEntity.ok(departmentService.viewAll());
			
		}
	 

}