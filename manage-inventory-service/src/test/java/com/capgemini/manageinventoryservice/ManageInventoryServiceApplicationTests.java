package com.capgemini.manageinventoryservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.Before;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;

import com.capgemini.manageinventoryservice.entity.Inventory;
import com.capgemini.manageinventoryservice.mapper.InventoryMapper;
import com.capgemini.manageinventoryservice.model.InventoryModel;
import com.capgemini.manageinventoryservice.repository.InventoryRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ManageInventoryServiceApplicationTests {

	@Autowired
	private Validator validator;

	@Autowired
	private InventoryMapper mapper;

	@Autowired
	private InventoryRepository repository;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@Order(1)
	public void testAdd() {
		InventoryModel inventory = new InventoryModel();
		inventory.setId(101);
		inventory.setItemname("Chair");
		inventory.setQuantity(5);
		repository.save(mapper.mapDtoToEnttity(inventory));
		assertNotNull(repository.findById(101));

	}

	@Test
	// when all the validations are true
	public void testAdd2() {
		InventoryModel inventory = new InventoryModel();
		inventory.setId(102);
		inventory.setItemname("bed");
		inventory.setQuantity(5);
		repository.save(mapper.mapDtoToEnttity(inventory));
		Set<ConstraintViolation<InventoryModel>> violations = validator.validate(inventory);
		assertTrue(violations.isEmpty());

	}

	@Test
//when a item is missed to be entered
	public void testAdd3() {
		InventoryModel inventory = new InventoryModel();
		inventory.setId(103);
		inventory.setItemname("");
		inventory.setQuantity(5);
		Set<ConstraintViolation<InventoryModel>> violations = validator.validate(inventory);
		assertFalse(violations.isEmpty());

	}

	@Test
//when a item entered has incorrect value
	public void testAdd4() {
		InventoryModel inventory = new InventoryModel();
		inventory.setId(103);
		inventory.setItemname("Cup");
		inventory.setQuantity(102);
		Set<ConstraintViolation<InventoryModel>> violations = validator.validate(inventory);
		assertFalse(violations.isEmpty());

	}

	@Test
	@Order(2)
	public void testUpdate() {
		InventoryModel inven = mapper.mapEntityToDto(repository.findById(101));
		inven.setQuantity(11);
		repository.save(mapper.mapDtoToEnttity(inven));
		assertNotEquals(10, repository.findById(101).getQuantity());

	}

	@Test
	// when a updated value to be entered is missed
	public void testUpdate2() {
		InventoryModel inven = mapper.mapEntityToDto(repository.findById(102));
		inven.setItemname("");
		repository.save(mapper.mapDtoToEnttity(inven));
		Set<ConstraintViolation<InventoryModel>> violations = validator.validate(inven);
		assertFalse(violations.isEmpty());
	}

	@Test
	// when a updated value to be entered is incorrect
	public void testUpdate3() {
		InventoryModel inven = mapper.mapEntityToDto(repository.findById(102));
		inven.setQuantity(101);
		repository.save(mapper.mapDtoToEnttity(inven));
		Set<ConstraintViolation<InventoryModel>> violations = validator.validate(inven);
		assertFalse(violations.isEmpty());
	}

	@Test
	@Order(3)
	public void testView() {
		Inventory inven = repository.findById(101);
		assertEquals("Chair", inven.getItemname());
	}

	@Test
	@Order(4)
	public void testViewAll() {
		List<Inventory> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	@Order(5)
	public void testDelete() {
		repository.deleteById(101);
		assertThat(repository.existsById(101)).isFalse();
	}

	@Test
	// when a wrong value is entered
	public void testDelete2() {
		repository.deleteById(102);
		assertThat(repository.existsById(101)).isFalse();
	}

}