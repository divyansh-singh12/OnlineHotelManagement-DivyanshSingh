package com.capgemini.manageroomservice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.manageroomservice.entity.Room;
import com.capgemini.manageroomservice.mapper.RoomMapper;
import com.capgemini.manageroomservice.model.AddRoomModel;
import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.model.SetRatesModel;
import com.capgemini.manageroomservice.repository.RoomRepository;

@SpringBootTest
class ManageRoomServiceApplicationTests {

	@Autowired
	private Validator validator;

	@Autowired
	RoomRepository repo;

	@Autowired
	RoomMapper mapper;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@Order(1)
	public void addTest() {

		AddRoomModel room = new AddRoomModel();
		room.setRoomno(21);
		room.setType("standard");
		room.setStatus("available");
		room.setCapacity(2);
		RoomModel model = new RoomModel();
		BeanUtils.copyProperties(room, model);
		repo.save(mapper.mapDtoToEntity(model));
		assertNotNull(repo.findById(21));

	}

	@Test

	public void addTest2() {

		AddRoomModel room = new AddRoomModel();
		room.setRoomno(22);
		room.setType("standard");
		room.setStatus("available");
		room.setCapacity(2);
		RoomModel model = new RoomModel();
		BeanUtils.copyProperties(room, model);
		repo.save(mapper.mapDtoToEntity(model));
		Set<ConstraintViolation<AddRoomModel>> violations = validator.validate(room);
		assertTrue(violations.isEmpty());

	}

	@Test

	public void addTest3() {

		AddRoomModel room = new AddRoomModel();
		room.setRoomno(23);
		room.setType("");
		room.setStatus("available");
		room.setCapacity(2);
		RoomModel model = new RoomModel();
		BeanUtils.copyProperties(room, model);
		repo.save(mapper.mapDtoToEntity(model));
		Set<ConstraintViolation<AddRoomModel>> violations = validator.validate(room);
		assertFalse(violations.isEmpty());

	}

	@Test

	public void addTest4() {

		AddRoomModel room = new AddRoomModel();
		room.setRoomno(24);
		room.setType("Standard");
		room.setStatus("available");
		room.setCapacity(0);
		RoomModel model = new RoomModel();
		BeanUtils.copyProperties(room, model);
		repo.save(mapper.mapDtoToEntity(model));
		Set<ConstraintViolation<AddRoomModel>> violations = validator.validate(room);
		assertFalse(violations.isEmpty());

	}

	@Test
	@Order(2)
	public void updateTest() {
		AddRoomModel room = new AddRoomModel();
		room.setCapacity(6);
		RoomModel model = mapper.mapEntityToDto(repo.findByRoomno(21));
		model.setCapacity(room.getCapacity());

		repo.save(mapper.mapDtoToEntity(model));
		assertEquals(6, repo.findById(21).getCapacity());
	}

	@Test
	public void updateTest2() {
		AddRoomModel room = new AddRoomModel();
		room.setCapacity(7);
		RoomModel model = mapper.mapEntityToDto(repo.findByRoomno(21));
		model.setCapacity(room.getCapacity());

		repo.save(mapper.mapDtoToEntity(model));
		Set<ConstraintViolation<AddRoomModel>> violations = validator.validate(room);
		assertFalse(violations.isEmpty());

	}

	@Test
	public void updateTest3() {
		AddRoomModel room = new AddRoomModel();
		room.setStatus("");
		RoomModel model = mapper.mapEntityToDto(repo.findByRoomno(21));
		model.setStatus(room.getStatus());

		repo.save(mapper.mapDtoToEntity(model));
		Set<ConstraintViolation<AddRoomModel>> violations = validator.validate(room);
		assertFalse(violations.isEmpty());

	}

	@Test
	@Order(3)
	public void viewByIdTest() {
		assertEquals("standard", repo.findById(22).getType());
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
		repo.deleteById(23);
		assertThat(repo.existsById(11)).isFalse();
	}

	@Test

	public void deleteTest2() {
		repo.deleteById(24);
		assertThat(repo.existsById(21)).isTrue();
	}

	@SuppressWarnings("deprecation")
	@Test
	@Order(8)
	public void setRatesTest() {
		Time t1 = new Time(11, 30, 55);
		Time t2 = new Time(12, 30, 55);
		SetRatesModel rate = new SetRatesModel();
		rate.setCapacity(2);
		rate.setType("Standard");
		rate.setFirst_night_rate(500);
		rate.setExtension_rate(500);
		rate.setCheck_in_time(t1);
		rate.setCheck_out_time(t2);

		List<Room> roomList = repo.findAllByTypeAndCapacity(rate.getType(), rate.getCapacity());

		for (Room roomdata : roomList) {
			Room demoroom = roomdata;
			demoroom.setCheck_in_time(rate.getCheck_in_time());
			demoroom.setCheck_out_time(rate.getCheck_out_time());
			demoroom.setFirst_night_rate(rate.getFirst_night_rate());
			demoroom.setExtension_rate(rate.getExtension_rate());
			@SuppressWarnings("unused")
			Room lossdata = repo.save(demoroom);
		}

		List<Room> roomList1 = repo.findAllByTypeAndCapacity(rate.getType(), rate.getCapacity());
		assertEquals(500, roomList1.get(0).getFirst_night_rate());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void setRatesTest2() {
		Time t1 = new Time(11, 30, 55);
		Time t2 = new Time(12, 30, 55);
		SetRatesModel rate = new SetRatesModel();
		rate.setCapacity(3);
		rate.setType("Standard");
		rate.setFirst_night_rate(500);
		rate.setExtension_rate(500);
		rate.setCheck_in_time(t1);
		rate.setCheck_out_time(t2);

		List<Room> roomList = repo.findAllByTypeAndCapacity(rate.getType(), rate.getCapacity());

		for (Room roomdata : roomList) {
			Room demoroom = roomdata;
			demoroom.setCheck_in_time(rate.getCheck_in_time());
			demoroom.setCheck_out_time(rate.getCheck_out_time());
			demoroom.setFirst_night_rate(rate.getFirst_night_rate());
			demoroom.setExtension_rate(rate.getExtension_rate());
			@SuppressWarnings("unused")
			Room lossdata = repo.save(demoroom);
		}

		List<Room> roomList1 = repo.findAllByTypeAndCapacity(rate.getType(), rate.getCapacity());
		assertTrue(roomList1.isEmpty());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void setRatesTest3() {
		Time t1 = new Time(11, 30, 55);
		Time t2 = new Time(12, 30, 55);
		SetRatesModel rate = new SetRatesModel();
		rate.setCapacity(2);
		rate.setType("Standard");
		rate.setFirst_night_rate(600);
		rate.setExtension_rate(600);
		rate.setCheck_in_time(t1);
		rate.setCheck_out_time(t2);

		List<Room> roomList1 = repo.findAllByTypeAndCapacity(rate.getType(), rate.getCapacity());
		assertNotEquals(600, roomList1.get(0).getFirst_night_rate());
	}
}