package com.capgemini.manageinventoryservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;
import com.capgemini.manageinventoryservice.entity.Inventory;
import com.capgemini.manageinventoryservice.repository.InventoryRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ManageInventoryServiceApplicationTests {

	@Autowired
	private InventoryRepository repository;

	@Test
	@Order(1)
	public void testAdd() {
		Inventory inventory = new Inventory();
		inventory.setId(101);
		inventory.setItemname("Chair");
		inventory.setQuantity(5);
		repository.save(inventory);
		assertNotNull(repository.findById(101));
	}

	@Test
	@Order(2)
	public void testUpdate() {
		Inventory inven = repository.findById(101);
		inven.setQuantity(11);
		repository.save(inven);
		assertNotEquals(10, repository.findById(101).getQuantity());

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
}