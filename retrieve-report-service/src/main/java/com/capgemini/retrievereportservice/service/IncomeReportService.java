package com.capgemini.retrievereportservice.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.capgemini.retrievereportservice.model.IncomeList;

@Service
public interface IncomeReportService {
	public File generateIncomeReport(IncomeList incomelist);
}
