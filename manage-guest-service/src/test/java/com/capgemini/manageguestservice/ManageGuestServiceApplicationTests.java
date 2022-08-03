package com.capgemini.manageguestservice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.manageguestservice.entity.Address;
import com.capgemini.manageguestservice.entity.Guest;
import com.capgemini.manageguestservice.repository.GuestRepository;

@SpringBootTest
class ManageGuestServiceApplicationTests {

	@Autowired
	GuestRepository repo;

	@Test
	@Order(1)
	public void addTest() {

		Guest guest = new Guest();
		Address address = new Address();

		address.setId(1);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Chandpur");
		address.setState("U.P");
		address.setPincode(246725);
		address.setCountry("India");
		guest.setId(101);
		guest.setFirstName("Divyansh");
		guest.setLastName("Singh");
		guest.setPhoneNumber("9536122002");
		guest.setCompany("Capgemini");
		guest.setGender("Male");
		guest.setEmail("silentknight1010@gmail.com");
		guest.setAddress(address);
		repo.save(guest);
		assertNotNull(repo.findById(101));

		address.setId(2);
		address.setHouseNo("H.no 20");
		address.setStreetName("Kawad road");
		address.setCity("Chandpur");
		address.setState("U.P");
		address.setPincode(246725);
		address.setCountry("India");
		guest.setId(102);
		guest.setFirstName("Divyansh");
		guest.setLastName("Singh");
		guest.setPhoneNumber("9536122002");
		guest.setCompany("Capgemini");
		guest.setGender("Male");
		guest.setEmail("silentknight1010@gmail.com");
		guest.setAddress(address);
		repo.save(guest);
		assertNotNull(repo.findById(102));

	}

	@Test
	@Order(2)
	public void updateTest() {
		Guest guest = repo.findById(101);
		guest.setCompany("CAPGEMINI");
		;
		repo.save(guest);
		assertNotEquals("Capgemini", repo.findById(101).getCompany());
	}

	@Test
	@Order(3)
	public void viewTest() {
		assertEquals("Singh", repo.findById(101).getLastName());
	}

	@Test
	@Order(4)
	public void viewAllTest() {
		List<Guest> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

}