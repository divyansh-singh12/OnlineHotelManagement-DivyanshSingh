package com.capgemini.managedepartmentservice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.managedepartmentservice.entity.Department;
import com.capgemini.managedepartmentservice.repository.DepartmentRepository;

@SpringBootTest
class ManageDepartmentServiceApplicationTests {

	@Autowired
	DepartmentRepository repository;

	@Test
	@Order(1)
	public void testAdd() {
		Department department = new Department();
		department.setId(101);
		department.setName("Harsh");
		department.setHodName("Vishu");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);
		repository.save(department);
		assertNotNull(repository.findById(101));
		department.setId(102);
		department.setName("Harsh");
		department.setHodName("Vishu");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);
		repository.save(department);
		assertNotNull(repository.findById(101));
	}

	@Test
	@Order(2)
	public void testUpdate() {
		Department department = repository.findById(102);
		department.setSizeOfDepartment(40);
		repository.save(department);
		assertNotEquals(20, repository.findById(102).getSizeOfDepartment());
	}

	@Test
	@Order(3)
	public void testView() {

		assertEquals("Harsh", repository.findById(101).getName());
	}

	@Test
	@Order(4)
	public void testViewAll() {
		List<Department> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(8)
	public void testDelete() {
		repository.deleteById(101);
		assertThat(repository.existsById(101)).isFalse();
	}

}