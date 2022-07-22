package com.capgemini.managestaffservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.managestaffservice.entity.Staff;
import com.capgemini.managestaffservice.model.StaffModel;

@Component
public class StaffMapper {
	@Autowired
	private AddressMapper addressMapper;
	public Staff mapDtoToEntity(StaffModel staff) {
		Staff staffEntity=new Staff();
		staffEntity.setCode(staff.getCode());
		staffEntity.setFirstname(staff.getFirstname());
		staffEntity.setLastname(staff.getLastname());
		staffEntity.setSalary(staff.getSalary());
		staffEntity.setJoinedon(staff.getJoinedon());
		staffEntity.setAge(staff.getAge());
		staffEntity.setOccupation(staff.getOccupation());
		staffEntity.setEmail(staff.getEmail());
		staffEntity.setAddress(addressMapper.mapDtoToEntity(staff.getAddress()));
		return staffEntity;
	}
	public StaffModel mapEntityToDto(Staff staff) {
		StaffModel staffModel= new StaffModel();
		staffModel.setCode(staff.getCode());
		staffModel.setFirstname(staff.getFirstname());
		staffModel.setLastname(staff.getLastname());
		staffModel.setSalary(staff.getSalary());
		staffModel.setJoinedon(staff.getJoinedon());
		staffModel.setAge(staff.getAge());
		staffModel.setOccupation(staff.getOccupation());
		staffModel.setEmail(staff.getEmail());
		staffModel.setAddress(addressMapper.mapEntityToDto(staff.getAddress()));
		return staffModel;
	}
}
