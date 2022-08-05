package com.capgemini.manageguestservice;

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
import org.junit.Before;

import com.capgemini.manageguestservice.entity.Address;
import com.capgemini.manageguestservice.entity.Guest;
import com.capgemini.manageguestservice.mapper.GuestMapper;
import com.capgemini.manageguestservice.model.AddressModel;
import com.capgemini.manageguestservice.model.GuestModel;
import com.capgemini.manageguestservice.repository.GuestRepository;

@SpringBootTest
class ManageGuestServiceApplicationTests {

	@Autowired
	private Validator validator;

	@Autowired
	GuestMapper mapper;

	@Autowired
	GuestRepository repo;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@Order(1)
	public void addTest() {

		Guest guest = new Guest();
		Address address = new Address();

		address.setId(1);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		guest.setId(101);
		guest.setFirstName("Harsh");
		guest.setLastName("Chaudhary");
		guest.setPhoneNumber("9536122002");
		guest.setCompany("Capgemini");
		guest.setGender("Male");
		guest.setEmail("tyghif@gmail.com");
		guest.setAddress(address);
		repo.save(guest);
		assertNotNull(repo.findById(101));

	}

	@Test
	// when all the validations are true
	public void addTest2() {
		GuestModel guest = new GuestModel();
		AddressModel address = new AddressModel();

		address.setId(2);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		guest.setId(102);
		guest.setFirstName("Harsh");
		guest.setLastName("Chaudhary");
		guest.setPhoneNumber("9536122002");
		guest.setCompany("CApgemini");
		guest.setGender("Male");
		guest.setEmail("tyghif@gmail.com");
		guest.setAddress(address);
		@SuppressWarnings("unused")
		Guest entity = repo.save(mapper.mapDtoToEntity(guest));
		Set<ConstraintViolation<GuestModel>> violations = validator.validate(guest);
		assertTrue(violations.isEmpty());
	}

	@Test
	// when a entry is wrong (pattern validation or incorrect value
	public void addTest3() {
		GuestModel guest = new GuestModel();
		AddressModel address = new AddressModel();

		address.setId(3);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Kanth");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		guest.setId(103);
		guest.setFirstName("Vishwadev");
		guest.setLastName("Gupta");
		guest.setPhoneNumber("9536");
		guest.setCompany("Capgemini");
		guest.setGender("Male");
		guest.setEmail("tyghif@gmail.com");
		guest.setAddress(address);
		Set<ConstraintViolation<GuestModel>> violations = validator.validate(guest);
		assertFalse(violations.isEmpty());
	}

	@Test
// when a value to be entered is missed
	public void addTest4() {

		GuestModel guest = new GuestModel();
		AddressModel address = new AddressModel();

		address.setId(4);
		address.setHouseNo("H.no 20");
		address.setStreetName("Sara road");
		address.setCity("Gaziabad");
		address.setState("U.P");
		address.setPincode(243601);
		address.setCountry("India");
		guest.setId(104);
		guest.setFirstName("Divyansh");
		guest.setLastName("");
		guest.setPhoneNumber("9536133303");
		guest.setCompany("Capgemini");
		guest.setGender("Male");
		guest.setEmail("tyghif@gmail.com");
		guest.setAddress(address);
		Set<ConstraintViolation<GuestModel>> violations = validator.validate(guest);
		assertFalse(violations.isEmpty());
	}

	@Test
	@Order(2)

	public void updateTest() {
		GuestModel guest = mapper.mapEntityToDto(repo.findById(102));
		guest.setCompany("Accenture");
		@SuppressWarnings("unused")
		Guest entity = repo.save(mapper.mapDtoToEntity(guest));
		assertNotEquals("Capgemini", repo.findById(102).getCompany());
	}

	@Test
	// when a updated entry is wrong pattern validation or incorrect value
	public void updateTest2() {
		GuestModel guest = mapper.mapEntityToDto(repo.findById(101));
		guest.setEmail("vishwgmail.com");
		@SuppressWarnings("unused")
		Guest entity = repo.save(mapper.mapDtoToEntity(guest));
		Set<ConstraintViolation<GuestModel>> violations = validator.validate(guest);
		assertFalse(violations.isEmpty());
	}

	@Test
	// when a updated value to be entered is missed
	public void updateTest3() {
		GuestModel guest = mapper.mapEntityToDto(repo.findById(101));
		guest.setEmail("");
		@SuppressWarnings("unused")
		Guest entity = repo.save(mapper.mapDtoToEntity(guest));
		Set<ConstraintViolation<GuestModel>> violations = validator.validate(guest);
		assertFalse(violations.isEmpty());
	}

	@Test
	@Order(3)
	public void viewTest() {
		assertEquals("Chaudhary", repo.findById(101).getLastName());
	}

	@Test
	@Order(4)
	public void viewAllTest() {
		List<Guest> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

}