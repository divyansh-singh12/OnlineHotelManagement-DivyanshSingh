package com.capgemini.retrievereportservice.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.retrievereportservice.entity.StaffPaymentReport;
import com.capgemini.retrievereportservice.model.StaffReportModel;

@Component
public class StaffReportMapper {

	public StaffPaymentReport mapDtoToEntity(StaffReportModel staff) {
		StaffPaymentReport staffEntity = new StaffPaymentReport();
		staffEntity.setCode(staff.getCode());
		staffEntity.setFirstname(staff.getFirstname());
		staffEntity.setLastname(staff.getLastname());
		staffEntity.setSalary(staff.getSalary());
		staffEntity.setJoinedon(staff.getJoinedon());
		return staffEntity;
	}

	public StaffReportModel mapEntityToDto(StaffPaymentReport staff) {
		StaffReportModel staffModel = new StaffReportModel();
		staffModel.setCode(staff.getCode());
		staffModel.setFirstname(staff.getFirstname());
		staffModel.setLastname(staff.getLastname());
		staffModel.setSalary(staff.getSalary());
		staffModel.setJoinedon(staff.getJoinedon());
		return staffModel;
	}

}