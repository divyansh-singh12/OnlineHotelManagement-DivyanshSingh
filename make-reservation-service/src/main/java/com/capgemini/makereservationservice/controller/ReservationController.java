package com.capgemini.makereservationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
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
}
