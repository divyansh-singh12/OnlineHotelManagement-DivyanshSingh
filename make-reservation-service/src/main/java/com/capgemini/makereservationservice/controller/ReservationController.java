package com.capgemini.makereservationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.makereservationservice.model.ReservationModel;
import com.capgemini.makereservationservice.service.ReservationService;

@RestController
@RequestMapping("/MakeReservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private RestTemplate resttemplate;
	
	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
			return ResponseEntity.ok("Hello World 6");
	}
	@PostMapping(value = "/doreservation",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> makeReservation(@RequestBody ReservationModel reservation){
		return ResponseEntity.ok(resttemplate.postForObject("http://localhost:8087/ManageRoom/bookedroom",reservationService.doReservation(reservation), String.class));
	}
	
	@GetMapping(value = "/viewbookings/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservationModel>> findAllBookingsByRoomno(@PathVariable int roomno) {
		return ResponseEntity.ok(reservationService.findBookingsOfRoom(roomno));
		
	}
	@GetMapping(value = "/viewall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<ReservationModel>> viewAll() {
		return ResponseEntity.ok(reservationService.findallBookings());
		
	}
}
