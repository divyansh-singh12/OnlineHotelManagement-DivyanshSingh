package com.capgemini.manageuserservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class LoginController {
	
	@RequestMapping("/success")
	public String dashboard() {
		return "Login Successful";
	}

}