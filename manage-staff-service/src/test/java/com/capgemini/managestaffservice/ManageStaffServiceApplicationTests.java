package com.capgemini.managestaffservice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.managestaffservice.entity.Staff;
import com.capgemini.managestaffservice.mapper.StaffMapper;
import com.capgemini.managestaffservice.model.AddressModel;
import com.capgemini.managestaffservice.model.StaffModel;
import com.capgemini.managestaffservice.repository.StaffRepository;

@SpringBootTest
class ManageStaffServiceApplicationTests {

	@Autowired
	private Validator validator;
	@Autowired
	StaffMapper mapper;
	@Autowired
	StaffRepository repo;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@Order(1)
	public void addTest() {
		@SuppressWarnings("deprecation")
		Date d1 = new Date(2000, 11, 21);
		StaffModel staff = new StaffModel();
		AddressModel address = new AddressModel();
		address.setId(101);
		address.setHouseNo("H-20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		staff.setCode(112);
		staff.setFirstname("Vishu");
		staff.setLastname("Chaudhary");
		staff.setSalary(10000);
		staff.setJoinedon(d1);
		staff.setEmail("harsh@gmail.com");
		staff.setAge(21);
		staff.setOccupation("developer");
		staff.setAddress(address);
		repo.save(mapper.mapDtoToEntity(staff));
		Set<ConstraintViolation<StaffModel>> violations = validator.validate(staff);
		assertTrue(violations.isEmpty());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addTest2() {
		Date d3 = new Date(2022, 05, 21);
		AddressModel address = new AddressModel();
		StaffModel staff = new StaffModel();
		address.setId(2);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		staff.setCode(201);
		staff.setFirstname("Vishwadev");
		staff.setLastname("Gupta");
		staff.setSalary(2000);
		staff.setJoinedon(d3);
		staff.setAge(23);
		staff.setOccupation("Plumber");
		staff.setEmail("Vishu@gmail");
		staff.setAddress(address);
		repo.save(mapper.mapDtoToEntity(staff));
		assertNotNull(repo.findById(201));
	}

	@Test
	public void addTest3() {
		@SuppressWarnings("deprecation")
		Date d3 = new Date(2000, 11, 21);
		StaffModel staff = new StaffModel();
		AddressModel address = new AddressModel();
		address.setId(2);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		staff.setCode(102);
		staff.setFirstname("Harsh");
		staff.setLastname("");
		staff.setSalary(15000);
		staff.setJoinedon(d3);
		staff.setEmail("harsh@gmail.com");
		staff.setAge(21);
		staff.setOccupation("DEV");
		staff.setAddress(address);
		repo.save(mapper.mapDtoToEntity(staff));
		Set<ConstraintViolation<StaffModel>> violations = validator.validate(staff);
		assertFalse(violations.isEmpty());
	}

	@Test
	public void addTest4() {
		@SuppressWarnings("deprecation")
		Date d4 = new Date(2000, 11, 21);
		StaffModel staff = new StaffModel();
		AddressModel address = new AddressModel();
		address.setId(3);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		staff.setCode(102);
		staff.setFirstname("Harsh");
		staff.setLastname("Gupta");
		staff.setSalary(15000);
		staff.setJoinedon(d4);
		staff.setEmail("harshgmail.com");
		staff.setAge(21);
		staff.setOccupation("DEV");
		staff.setAddress(address);
		repo.save(mapper.mapDtoToEntity(staff));

	}

	@Test
	// updates value is null
	public void updateTest2() {

		StaffModel staff = mapper.mapEntityToDto(repo.findById(102));
		AddressModel address = new AddressModel();
		staff.setAge(22);
		staff.setAddress(address);
		address.setCity("");
		Set<ConstraintViolation<StaffModel>> violations = validator.validate(staff);
		assertFalse(violations.isEmpty());

	}

	@Test
	// updates value is incorrect
	public void updateTest3() {

		StaffModel staff = mapper.mapEntityToDto(repo.findById(102));
		AddressModel address = new AddressModel();
		staff.setAge(17);
		staff.setAddress(address);
		address.setCity("Budaun");
		Set<ConstraintViolation<StaffModel>> violations = validator.validate(staff);
		assertFalse(violations.isEmpty());

	}

	@Test
	@Order(3)
	public void viewTest() {
		StaffModel staff = mapper.mapEntityToDto(repo.findById(102));
		assertEquals("DEV", staff.getOccupation());
	}

	@Test
	@Order(4)
	public void viewAllTest() {
		List<Staff> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void deleteTest() {
		repo.deleteById(102);
		assertThat(repo.existsById(102)).isFalse();
	}

	@Test

	public void deleteTest2() {
		repo.deleteById(201);
		assertThat(repo.existsById(103)).isFalse();
	}
}