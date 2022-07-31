package com.capgemini.makereservationservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.makereservationservice.model.BillModel;
import com.capgemini.makereservationservice.model.IncomeList;

@Service
public interface BillService {
	public BillModel issueBill(int roomNo);
	public IncomeList generateReport();
}
