package com.capgemini.manageuserservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageuserservice.model.JwtModel;
import com.capgemini.manageuserservice.service.JwtService;

@RestController
@RequestMapping("/ManageJwt")
@CrossOrigin

public class JwtController {
	@Autowired
	private JwtService jwtService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/getjwt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getjwt() {
		return ResponseEntity.ok(jwtService.getJwt());
	}
	
	@PostMapping(value = "/addjwt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateJwt(@RequestBody JwtModel jwtModel) {
		logger.info("Add jwt in DB has been accessed");
		return ResponseEntity.ok(jwtService.addJwt(jwtModel));
	}

	@DeleteMapping(value = "/deletejwt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDepartment() {
		logger.info("delete jwt from DB has been accessed");
		return ResponseEntity.ok(jwtService.deleteJwt(1));
	}

}
