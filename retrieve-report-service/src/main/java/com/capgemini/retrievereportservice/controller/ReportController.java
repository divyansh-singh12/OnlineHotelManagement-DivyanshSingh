package com.capgemini.retrievereportservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.FileInputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.retrievereportservice.model.IncomeList;
import com.capgemini.retrievereportservice.model.StaffList;
import com.capgemini.retrievereportservice.model.StaffReportModel;
import com.capgemini.retrievereportservice.service.IncomeReportService;
import com.capgemini.retrievereportservice.service.StaffReportService;

@RestController
@RequestMapping("/RetrieveReport")
public class ReportController {
	Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	private StaffReportService staffReportService;

	@Autowired
	private IncomeReportService incomeReportService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Hello Test has been accessed");
		return ResponseEntity.ok("Hello World-5");
	}

	@GetMapping(value = "/dbtest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StaffReportModel>> dbTest() {
		logger.info("DB Test for staff report has been accessed");
		return ResponseEntity.ok(staffReportService.getStaffPaymentService());
	}

	@GetMapping(value = "/generatestaffreport")
	public ResponseEntity<Object> generateStaffReport() {

		ResponseEntity<StaffList> staffList = restTemplate.getForEntity("http://localhost:8083/ManageStaff/reportdata",
				StaffList.class);
		File file = staffReportService.generateStaffRreport(staffList.getBody());
		try {
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			logger.info("Generate staff report has been accessed");
			return ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);
		} catch (Exception e) {
			logger.info("Error in generate staff report has been occured");
			return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/generateincomereport")
	public ResponseEntity<Object> generateIncomeReport() {
		ResponseEntity<IncomeList> incomeList = restTemplate.getForEntity("http://localhost:8086/IssueBill/reportdata",
				IncomeList.class);
		File file = incomeReportService.generateIncomeReport(incomeList.getBody());
		try {
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			logger.info("Generate income report has been accessed");
			return ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);
		} catch (Exception e) {
			logger.info("Error in generate income report has been occured");
			return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}