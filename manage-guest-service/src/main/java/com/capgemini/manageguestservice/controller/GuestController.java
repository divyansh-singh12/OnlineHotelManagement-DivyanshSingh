package com.capgemini.manageguestservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageguestservice.model.GuestModel;
import com.capgemini.manageguestservice.service.GuestService;

@RestController
@RequestMapping("/ManageGuest")
public class GuestController {
	Logger logger = LoggerFactory.getLogger(GuestController.class);
	@Autowired
	private GuestService guestService;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello test has been accessed");
		return ResponseEntity.ok("Hello World 8");
	}

	@PostMapping(value = "/addguest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuestModel> addGuest(@RequestBody GuestModel guest) {
		logger.info("Add guest has been accessed");
		return ResponseEntity.ok(guestService.addGuestService(guest));
	}

	@PutMapping(value = "/updateguest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuestModel> updateGuest(@RequestBody GuestModel guest) {
		logger.info("Update guest has been accessed");
		return ResponseEntity.ok(guestService.updateGuestService(guest));
	}

	@GetMapping(value = "/viewguest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuestModel> viewGuest(@RequestBody GuestModel guest) {
		logger.info("view guest by id has been accessed");
		return ResponseEntity.ok(guestService.viewGuestService(guest.getId()));
	}

	@GetMapping(value = "/viewguest/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuestModel> viewGuest(@PathVariable String email) {
		logger.info("View guest by email has been accessed");
		return ResponseEntity.ok(guestService.viewGuestService(email));
	}
}
