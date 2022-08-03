package com.capgemini.manageuserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageuserservice.model.EncoderModel;

@RestController
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/success")
	public String dashboard() {
		return "Login Successful";
	}

	@RequestMapping(value = "/getencoder", method = RequestMethod.GET)
	public ResponseEntity<EncoderModel> getEncoder() {
		EncoderModel model = new EncoderModel();
		model.setPasswordEncoderr(passwordEncoder);
		return ResponseEntity.ok(model);
	}
}