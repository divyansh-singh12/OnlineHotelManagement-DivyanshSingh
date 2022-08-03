package com.capgemini.manageroomservice;

import java.sql.Date;
import java.sql.Time;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.manageroomservice.entity.Room;
import com.capgemini.manageroomservice.repository.RoomRepository;

@SpringBootTest
class ManageRoomServiceApplicationTests {

	@Autowired
	RoomRepository repo;

	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void addTest() {
		Date d1 = new Date(2022 - 07 - 05);
		Time t1 = new Time(05, 30, 25);
		Time t2 = new Time(06, 30, 25);
		Room room = new Room();
		room.setRoomno(100);
		room.setType("Standard");
		room.setCapacity(4);
		room.setStatus("vacant");
		room.setBookedtill(d1);
		room.setCheck_in_time(t1);
		room.setCheck_out_time(t2);
		room.setExtension_rate(1000);
		room.setFirst_night_rate(800);
		repo.save(room);
		assertNotNull(repo.findById(100));

	}

	@Test
	@Order(2)
	public void updateTest() {
		Room room = repo.findById(100);
		room.setCapacity(6);
		repo.save(room);
		assertEquals(6, repo.findById(100).getCapacity());
	}

	@Test
	@Order(3)
	public void viewByIdTest() {
		assertEquals("Standard", repo.findById(100).getType());
	}

	@Test
	@Order(4)
	public void viewAllTest() {
		List<Room> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void viewAllByTypeAndCapacityTest() {
		List<Room> list = repo.findAllByTypeAndCapacity("Standard", 6);
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(6)
	public void viewByStatusTest() {
		List<Room> list = repo.findByStatus("vacant");
		assertThat(list).size().isGreaterThanOrEqualTo(0);
	}

	@Test
	@Order(7)
	public void deleteTest() {
		repo.deleteById(100);
		assertThat(repo.existsById(100)).isFalse();
	}
}