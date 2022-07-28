package com.capgemini.makereservationservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.makereservationservice.model.BillModel;

@Service
public interface BillService {
	public BillModel issueBill(int roomNo);
}
