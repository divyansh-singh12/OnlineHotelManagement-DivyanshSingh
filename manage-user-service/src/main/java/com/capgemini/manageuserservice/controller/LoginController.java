package com.capgemini.manageuserservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageuserservice.service.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/ManageLogin")
public class LoginController {

	@RequestMapping("/success")
	public String dashboard() {
		return "Login Successful";
	}

	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login() {
		return ResponseEntity.ok(UserDetailsServiceImpl.getUserRole());
	}

}