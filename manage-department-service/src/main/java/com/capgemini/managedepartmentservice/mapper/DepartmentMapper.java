package com.capgemini.managedepartmentservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.capgemini.managedepartmentservice.entity.Department;
import com.capgemini.managedepartmentservice.model.DepartmentModel;


@Component
public class DepartmentMapper {
	public Department mapDtoToEntity(DepartmentModel department) {
		Department departmentEntity = new Department();
		departmentEntity.setId(department.getId());
		departmentEntity.setName(department.getName());
		departmentEntity.setHodName(department.getHodName());
		departmentEntity.setHodPhoneNo(department.getHodPhoneNo());
		departmentEntity.setSizeOfDepartment(department.getSizeOfDepartment());
		
		return departmentEntity;

	}
	public DepartmentModel mapEntityToDto(Department department) {
		DepartmentModel departmentModel= new DepartmentModel();
		BeanUtils.copyProperties(department, departmentModel);
		return departmentModel;
	}
	
}