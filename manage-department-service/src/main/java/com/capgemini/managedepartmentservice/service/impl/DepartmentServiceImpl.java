package com.capgemini.managedepartmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.managedepartmentservice.entity.Department;
import com.capgemini.managedepartmentservice.mapper.DepartmentMapper;
import com.capgemini.managedepartmentservice.model.DepartmentModel;
import com.capgemini.managedepartmentservice.repository.DepartmentRepository;
import com.capgemini.managedepartmentservice.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentModel addDepartmentService(DepartmentModel department) {
		validateEntity(department);
		Department departmentEntity = departmentRepository.save(departmentMapper.mapDtoToEntity(department));
		return departmentMapper.mapEntityToDto(departmentEntity);
	}

	public DepartmentModel updateDepartmentService(DepartmentModel department) {
		validateEntity(department);
		Department departmentEntity = departmentRepository.findById(department.getId());
		departmentEntity.setName(department.getName());
		departmentEntity.setHodName(department.getHodName());
		departmentEntity.setHodPhoneNo(department.getHodPhoneNo());
		departmentEntity.setSizeOfDepartment(department.getSizeOfDepartment());
		departmentEntity = departmentRepository.save(departmentEntity);
		return departmentMapper.mapEntityToDto(departmentEntity);
	}

	public String deleteDepartmentService(int id) {
		try {
			departmentRepository.deleteById(id);
			return "Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't delete";
	}

	public DepartmentModel viewDepartmentByName(String name) {
		Department departmentEntity = departmentRepository.findByName(name);
		return departmentMapper.mapEntityToDto(departmentEntity);
	}

	public List<DepartmentModel> viewAll() {
		List<Department> departmentList = departmentRepository.findAll();
		List<DepartmentModel> modelList = new ArrayList<DepartmentModel>();
		for (Department department : departmentList) {
			modelList.add(departmentMapper.mapEntityToDto(department));
		}
		return modelList;
	}

	private void validateEntity(DepartmentModel department) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<DepartmentModel>> constraintViolations = validator.validate(department);

		for (ConstraintViolation<DepartmentModel> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

}