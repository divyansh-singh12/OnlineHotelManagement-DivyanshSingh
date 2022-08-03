package com.capgemini.manageroomservice.controller;

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

import com.capgemini.manageroomservice.model.AddRoomModel;
import com.capgemini.manageroomservice.model.BookData;
import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.model.SetRatesModel;
import com.capgemini.manageroomservice.service.RoomService;

@RestController
@RequestMapping("/ManageRoom")
public class RoomController {
	Logger logger = LoggerFactory.getLogger(RoomController.class);
	@Autowired
	private RoomService roomService;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello test has been accessed");
		return ResponseEntity.ok("Hello World 7");
	}

	@PostMapping(value = "/addroom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomModel> addRoom(@RequestBody AddRoomModel room) {
		logger.info("Add room has been accessed");
		return ResponseEntity.ok(roomService.addRoomService(room));
	}

	@PutMapping(value = "/updateroom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomModel> updateRoom(@RequestBody AddRoomModel room) {
		logger.info("Update room has been accessed");
		return ResponseEntity.ok(roomService.updateRoomService(room));
	}

	@DeleteMapping(value = "/deleteroom/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRoom(@PathVariable int roomno) {
		logger.info("Delete room has been accessed");
		return ResponseEntity.ok(roomService.deleteRoomService(roomno));
	}

	@PutMapping(value = "/setrates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setrates(@RequestBody SetRatesModel room) {
		logger.info("set room rates has been accessed");
		return ResponseEntity.ok(roomService.setRatesService(room));
	}

	@PostMapping(value = "/bookedroom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> bookedRoom(@RequestBody BookData bookData) {
		logger.info("Booked room has been accessed");
		return ResponseEntity.ok(roomService.bookedRoom(bookData));
	}

	@GetMapping(value = "/viewroom/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomModel> viewRoom(@PathVariable int roomno) {
		logger.info("View room by id has been accessed");
		return ResponseEntity.ok(roomService.viewroom(roomno));
	}

}
