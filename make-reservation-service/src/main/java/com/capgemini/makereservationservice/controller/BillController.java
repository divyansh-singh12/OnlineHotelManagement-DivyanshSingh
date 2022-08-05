package com.capgemini.makereservationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private BillService billService;

	@Autowired
	private EmailService service;

	@GetMapping(value = "/{roomno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> issueBill(@PathVariable int roomno) {
		BillModel billmodel = billService.issueBill(roomno);
		if(billmodel.getBillid() == 0) {
			return new ResponseEntity<>("NO BOOKING FOUND TO ISSUE BILL FOR NOW", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		StringBuilder maildata = new StringBuilder(
				"Hello Guest, \n\nThank you for choosing us as your staying destination. Your bill has been generated and details are as follows: \n");
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

		service.sendSimpleEmail(billmodel.getGuestEmail(), "Issued Room Bill ", maildata.toString());
		logger.info("Issue Bill has been accessed");
		return ResponseEntity.ok(billmodel);
	}

	@GetMapping(value = "/reportdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncomeList> incomereport() {
		logger.info("Report data for income has been accessed");
		return ResponseEntity.ok(billService.generateReport());
	}

}
