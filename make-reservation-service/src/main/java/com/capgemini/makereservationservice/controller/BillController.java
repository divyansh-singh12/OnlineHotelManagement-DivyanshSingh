package com.capgemini.makereservationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.makereservationservice.model.BillModel;
import com.capgemini.makereservationservice.model.IncomeList;
import com.capgemini.makereservationservice.service.BillService;
import com.capgemini.makereservationservice.service.EmailService;

@RestController
@RequestMapping("/IssueBill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private EmailService service;
	
	@GetMapping(value = "/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillModel> issueBill(@PathVariable int roomno){
		BillModel billmodel= billService.issueBill(roomno);
		
		StringBuilder maildata = new StringBuilder("Hello Guest, \n thank you for choosing us as your Staying destination. your bill has been generated and details are as follows: \n");
		maildata.append("Bill ID: ").append(billmodel.getBillid()).append("\n");
		maildata.append("Booked Room: ").append(billmodel.getRoomno()).append("\n");
		maildata.append("Room Type: ").append(billmodel.getRoomType()).append("\n");
		maildata.append("Bill Date: ").append(billmodel.getBillDate()).append("\n");
		maildata.append("Staying Days: ").append(billmodel.getDays()).append("\n");
		maildata.append("Rate: ").append(billmodel.getRate()).append("\n");
		maildata.append("Extension Days: ").append(billmodel.getExtensiondays()).append("\n");
		maildata.append("Extension Rate: ").append(billmodel.getExtensionRate()).append("\n");
		maildata.append("Tax: ").append(billmodel.getTax()).append("\n");
		maildata.append("Total Bill: ").append(billmodel.getTotalBill()).append("\n");
		maildata.append("Thank you. hope you had a great time with us.");
		
		service.sendSimpleEmail(billmodel.getGuestEmail(), "Issued Room Bill ",maildata.toString());
		
		return ResponseEntity.ok(billmodel);
	}
	
	@GetMapping(value="/reportdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncomeList> incomereport(){
		return ResponseEntity.ok(billService.generateReport());
	}
	
}
