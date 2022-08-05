package com.capgemini.makereservationservice;

import java.sql.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.makereservationservice.mapper.ReservationMapper;
import com.capgemini.makereservationservice.model.ReservationModel;
import com.capgemini.makereservationservice.repository.ReservationRepository;

@SpringBootTest
class MakeReservationServiceApplicationTests {

	@Autowired
	private Validator validator;

	@Autowired
	ReservationMapper mapper;

	@Autowired
	ReservationRepository repo;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void doReservationTest() {

		Date d1 = new Date(2022, 05, 06);
		Date d2 = new Date(2022, 05, 10);

		ReservationModel res = new ReservationModel();
		res.setCode(101);
		res.setGuestEmail("harsh@capegemini.com");
		res.setGuestPhoneNo("9536133303");
		res.setRoomno(201);
		res.setStatus("available");
		res.setNoOfNight(2);
		res.setNoOfChildren(2);
		res.setNoOfAdult(2);
		res.setCheckIn(d1);
		res.setCheckOut(d2);
		repo.save(mapper.mapDtoToEntity(res));
		assertNotNull(repo.findById(101));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void doReservationTest2() {

		Date d1 = new Date(2022, 05, 06);
		Date d2 = new Date(2022, 05, 10);

		ReservationModel res = new ReservationModel();
		res.setCode(101);
		res.setGuestEmail("vishu@capegemini.com");
		res.setGuestPhoneNo("9536133303");
		res.setRoomno(201);
		res.setStatus("available");
		res.setNoOfNight(2);
		res.setNoOfChildren(2);
		res.setNoOfAdult(2);
		res.setCheckIn(d1);
		res.setCheckOut(d2);
		repo.save(mapper.mapDtoToEntity(res));
		Set<ConstraintViolation<ReservationModel>> violations = validator.validate(res);
		assertTrue(violations.isEmpty());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void doReservationTest3() {

		Date d1 = new Date(2022, 05, 06);
		Date d2 = new Date(2022, 05, 10);

		ReservationModel res = new ReservationModel();
		res.setCode(101);
		res.setGuestEmail("vishu@capegemini.com");
		res.setGuestPhoneNo("9536");
		res.setRoomno(201);
		res.setStatus("available");
		res.setNoOfNight(2);
		res.setNoOfChildren(2);
		res.setNoOfAdult(2);
		res.setCheckIn(d1);
		res.setCheckOut(d2);
		repo.save(mapper.mapDtoToEntity(res));
		Set<ConstraintViolation<ReservationModel>> violations = validator.validate(res);
		assertFalse(violations.isEmpty());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void doReservationTest4() {

		Date d1 = new Date(2022, 05, 06);
		Date d2 = new Date(2022, 05, 10);

		ReservationModel res = new ReservationModel();
		res.setCode(101);
		res.setGuestEmail("vishu@capegemini.com");
		res.setGuestPhoneNo("");
		res.setRoomno(201);
		res.setStatus("");
		res.setNoOfNight(2);
		res.setNoOfChildren(2);
		res.setNoOfAdult(2);
		res.setCheckIn(d1);
		res.setCheckOut(d2);
		repo.save(mapper.mapDtoToEntity(res));
		Set<ConstraintViolation<ReservationModel>> violations = validator.validate(res);
		assertFalse(violations.isEmpty());
	}

}