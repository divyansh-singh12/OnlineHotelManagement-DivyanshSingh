package com.capgemini.makereservationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.makereservationservice.model.BillModel;
import com.capgemini.makereservationservice.service.BillService;

@RestController
@RequestMapping("/IssueBill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping(value = "/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillModel> issueBill(@PathVariable int roomno){
		return ResponseEntity.ok(billService.issueBill(roomno));
	}
}
