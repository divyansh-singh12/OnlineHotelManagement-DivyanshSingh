package com.capgemini.managedepartmentservice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;
import com.capgemini.managedepartmentservice.entity.Department;
import com.capgemini.managedepartmentservice.mapper.DepartmentMapper;
import com.capgemini.managedepartmentservice.model.DepartmentModel;
import com.capgemini.managedepartmentservice.repository.DepartmentRepository;

@SpringBootTest
class ManageDepartmentServiceApplicationTests {
	@Autowired
	private Validator validator;

	@Autowired
	DepartmentMapper mapper;

	@Autowired
	DepartmentRepository repository;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@Order(1)
	public void testAdd() {
		Department department = new Department();
		department.setId(11);
		department.setName("Test Department");
		department.setHodName("Unit Test");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);
		repository.save(department);
		assertNotNull(repository.findById(11));
		department.setId(12);
		department.setName("Test Department 2");
		department.setHodName("Unit Test");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);
		repository.save(department);
		assertNotNull(repository.findById(11));
	}

	// if any entity is filled with wrong data
	@Test
	public void testAdd2() {
		DepartmentModel department = new DepartmentModel();
		department.setId(13);
		department.setName("Test Department 3");
		department.setHodName("Unit Test");
		department.setSizeOfDepartment(20);
		repository.save(mapper.mapDtoToEntity(department));

		assertNull(repository.findById(13).getHodPhoneNo());
	}

	@Test
// when a validation is missed
	public void testAdd3() {
		DepartmentModel department = new DepartmentModel();
		department.setId(14);
		department.setName("Test Department 4");
		department.setHodName("Unit Test");
		department.setHodPhoneNo("9536133");
		department.setSizeOfDepartment(20);

		Set<ConstraintViolation<DepartmentModel>> violations = validator.validate(department);
		assertFalse(violations.isEmpty());
	}

	@Test
	// when a validation is missed
	public void testAdd4() {
		DepartmentModel department = new DepartmentModel();
		department.setId(15);
		department.setName("");
		department.setHodName("Unit Test");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);

		Set<ConstraintViolation<DepartmentModel>> violations = validator.validate(department);
		assertFalse(violations.isEmpty());
	}

	@Test
	// when a validation is missed
	public void testAdd5() {
		DepartmentModel department = new DepartmentModel();
		department.setId(16);
		department.setName("Test Department 6");
		department.setHodName("");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);

		Set<ConstraintViolation<DepartmentModel>> violations = validator.validate(department);
		assertFalse(violations.isEmpty());
	}

	@Test
	// when a validation is missed
	public void testAdd6() {
		DepartmentModel department = new DepartmentModel();
		department.setId(16);
		department.setName("Test Department 6");
		department.setHodName("Unit Test");
		department.setHodPhoneNo("9536133303");
		department.setSizeOfDepartment(20);
		@SuppressWarnings("unused")
		Department entity = repository.save(mapper.mapDtoToEntity(department));
		assertNotNull(repository.findById(16));

	}

	@Test
	@Order(2)
	public void testUpdate() {
		DepartmentModel department = mapper.mapEntityToDto(repository.findById(16));
		department.setSizeOfDepartment(20);
		@SuppressWarnings("unused")
		Department entity = repository.save(mapper.mapDtoToEntity(department));
		assertNotEquals(19, repository.findById(16).getSizeOfDepartment());
	}

	@Test
	// when a validation is missed
	public void testUpdate2() {
		DepartmentModel department = mapper.mapEntityToDto(repository.findById(12));
		department.setHodPhoneNo("953613");

		Set<ConstraintViolation<DepartmentModel>> violations = validator.validate(department);
		assertFalse(violations.isEmpty());
	}

	@Test
	@Order(3)
	public void testView() {

		assertEquals("Test Department", repository.findById(11).getName());
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
		repository.deleteById(11);
		assertThat(repository.existsById(11)).isFalse();
	}

	@Test

	public void testDelete2() {
		repository.deleteById(12);
		assertThat(repository.existsById(11)).isTrue();
	}

}