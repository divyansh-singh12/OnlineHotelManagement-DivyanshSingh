package com.capgemini.managestaffservice.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.capgemini.managestaffservice.model.StaffModel;

@Service
public interface StaffService {
	public StaffModel addStaffService(StaffModel staff);
	public StaffModel updateStaffService(StaffModel staff);
	public String deleteStaffService(int id);
	public StaffModel viewStaffService(int id);
	public List<StaffModel> viewAllList();
}
