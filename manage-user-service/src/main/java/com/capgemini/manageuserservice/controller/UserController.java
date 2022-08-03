package com.capgemini.manageuserservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.capgemini.manageuserservice.model.UserModel;
import com.capgemini.manageuserservice.service.UserService;

@RestController
@RequestMapping("/ManageUser")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello Test has been accessed");
		return ResponseEntity.ok("Hello World-9");
	}

	@PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
		logger.info("Add user has been accessed");
		return ResponseEntity.ok(userService.addUserService(user));
	}

	@PutMapping(value = "/updateuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user) {
		logger.info("Update user has been accessed");
		return ResponseEntity.ok(userService.updateUserService(user));
	}

	@DeleteMapping(value = "/deleteuser/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUser(@PathVariable String username) {
		logger.info("Delete user has been accessed");
		return ResponseEntity.ok(userService.deleteUserService(username));
	}

	@GetMapping(value = "/checkuser/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> checkUser(@PathVariable String username) {
		UserModel model = userService.checkUser(username);
		System.out.println(model.getName());
		System.out.println(model.getPassword());
		logger.info("Check user has been accessed");
		return ResponseEntity.ok(model);

	}
}