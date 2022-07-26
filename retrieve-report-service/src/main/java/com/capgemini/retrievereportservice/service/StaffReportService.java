package com.capgemini.retrievereportservice.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.retrievereportservice.model.StaffList;
import com.capgemini.retrievereportservice.model.StaffReportModel;

@Service
public interface StaffReportService {
	public File generateStaffRreport(StaffList staffList);
	public List<StaffReportModel> getStaffPaymentService(); 
}
