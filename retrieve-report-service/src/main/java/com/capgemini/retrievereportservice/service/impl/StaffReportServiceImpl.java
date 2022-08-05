package com.capgemini.retrievereportservice.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.retrievereportservice.entity.StaffPaymentReport;
import com.capgemini.retrievereportservice.mapper.StaffReportMapper;
import com.capgemini.retrievereportservice.model.StaffList;
import com.capgemini.retrievereportservice.model.StaffReportModel;
import com.capgemini.retrievereportservice.repository.StaffReportRepository;
import com.capgemini.retrievereportservice.service.StaffReportService;

@Component
public class StaffReportServiceImpl implements StaffReportService {
	@Autowired
	private StaffReportMapper staffReportMapper;
	@Autowired
	private StaffReportRepository staffReportRepository;

	public File generateStaffRreport(StaffList staffList) {
		staffReportRepository.deleteAll();
		List<StaffReportModel> sample = staffList.getStaffReportList();
		@SuppressWarnings("unused")
		StaffPaymentReport paymentReport;
		for (StaffReportModel reportModel : sample) {
			paymentReport = staffReportRepository.save(staffReportMapper.mapDtoToEntity(reportModel));
		}
		StringBuilder filecontent = new StringBuilder("STAFF_CODE,FIRST_NAME,LAST_NAME,SALARY,JOINED_ON\n");
		for (StaffReportModel reportModel : sample) {
			filecontent.append(reportModel.getCode()).append(",").append(reportModel.getFirstname()).append(",")
					.append(reportModel.getLastname()).append(",").append(reportModel.getSalary()).append(",")
					.append(reportModel.getJoinedon()).append("\n");
		}
		String filename = "D:\\Online Hotel Management System\\staff_report.csv";

		try {

			FileWriter filewriter = new FileWriter(filename);
			filewriter.write(filecontent.toString());
			filewriter.flush();
			filewriter.close();

		} catch (IOException e) {

			System.out.println(e);
		}

		File file = new File(filename);
		return file;
	}

	public List<StaffReportModel> getStaffPaymentService() {
		List<StaffPaymentReport> staffEntity = staffReportRepository.findAll();
		List<StaffReportModel> staffModel = new ArrayList<StaffReportModel>();
		for (StaffPaymentReport staff : staffEntity) {
			staffModel.add(staffReportMapper.mapEntityToDto(staff));
		}
		return staffModel;

	}
}
