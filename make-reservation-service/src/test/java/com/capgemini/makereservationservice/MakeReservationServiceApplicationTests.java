package com.capgemini.makereservationservice;

import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.makereservationservice.entity.Reservation;
import com.capgemini.makereservationservice.repository.ReservationRepository;

@SpringBootTest
class MakeReservationServiceApplicationTests {

	@Autowired
	ReservationRepository repo;

	@SuppressWarnings("deprecation")
	@Test
	public void doReservationTest() {

		Date d1 = new Date(2022, 05, 06);
		Date d2 = new Date(2022, 05, 10);

		Reservation res = new Reservation();
		res.setCode(101);
		res.setGuestEmail("harsh@capegemini.com");
		res.setGuestPhoneNo("953613333");
		res.setRoomno(201);
		res.setStatus("available");
		res.setNoOfNight(2);
		res.setNoOfChildren(2);
		res.setNoOfAdult(2);
		res.setCheckIn(d1);
		res.setCheckOut(d2);
		repo.save(res);
		assertNotNull(repo.findById(101));

	}

}