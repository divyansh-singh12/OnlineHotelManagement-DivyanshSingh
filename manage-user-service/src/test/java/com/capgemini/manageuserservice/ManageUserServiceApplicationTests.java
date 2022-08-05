package com.capgemini.manageuserservice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.manageuserservice.mapper.UserMapper;
import com.capgemini.manageuserservice.model.UserModel;
import com.capgemini.manageuserservice.repository.UserRepository;

@SpringBootTest
class ManageUserServiceApplicationTests {

	@Autowired
	private Validator validator;

	@Autowired
	UserMapper mapper;

	@Autowired
	UserRepository repo;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void addTest() {
		UserModel user = new UserModel();
		user.setUsername("h@capegemini.com");
		user.setName("harsh");
		user.setPassword("H@123");
		user.setRole("ROLE_OWNER");
		repo.save(mapper.mapDtoToEntity(user));
		assertNotNull(repo.findByUsername("h@capegemini.com"));

	}

	@Test
	public void addTest2() {
		UserModel user = new UserModel();
		user.setUsername("hv23@capegemini.com");
		user.setName("Vishu");
		user.setPassword("V@1234567");
		user.setRole("ROLE_OWNER");
		repo.save(mapper.mapDtoToEntity(user));
		Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
		assertTrue(violations.isEmpty());

	}

	@Test
	public void addTest3() {
		UserModel user = new UserModel();
		user.setUsername("hv231@capegemini.com");
		user.setName("Vishu");
		user.setPassword("");
		user.setRole("ROLE_OWNER");
		repo.save(mapper.mapDtoToEntity(user));
		Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
		assertFalse(violations.isEmpty());

	}

	@Test
	public void addTest4() {
		UserModel user = new UserModel();
		user.setUsername("hv231@capegemini.com");
		user.setName("Vishu");
		user.setPassword("v@12");
		user.setRole("ROLE_OWNER");
		repo.save(mapper.mapDtoToEntity(user));
		Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
		assertFalse(violations.isEmpty());

	}

	@Test
	public void updateTest() {
		UserModel user = mapper.mapEntityToDto(repo.findByUsername("h@capegemini.com"));
		user.setRole("ROLE_MANAGER");
		repo.save(mapper.mapDtoToEntity(user));
		assertNotEquals("OWNER", repo.findByUsername("h@capegemini.com").getRole());
	}

	@Test
	public void updateTest2() {
		UserModel user = mapper.mapEntityToDto(repo.findByUsername("h@capegemini.com"));
		user.setRole("");
		repo.save(mapper.mapDtoToEntity(user));
		Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
		assertFalse(violations.isEmpty());
	}

	@Test
	public void updateTest3() {
		UserModel user = mapper.mapEntityToDto(repo.findByUsername("hv231@capegemini.com"));
		user.setPassword("V@123");
		repo.save(mapper.mapDtoToEntity(user));
		Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
		assertFalse(violations.isEmpty());
	}

	@Test
	public void viewTest() {
		UserModel user = mapper.mapEntityToDto(repo.findByUsername("hv231@capegemini.com"));
		assertEquals("Vishu", user.getName());
	}

	@Test
	public void deleteTest() {
		repo.deleteById("h@capegemini.com");
		assertThat(repo.existsById("h@capegemini.com")).isFalse();

	}

	@Test
	public void deleteTest2() {
		repo.deleteById("hv23@capegemini.com");
		assertThat(repo.existsById("hv231@capegemini.com")).isTrue();

	}
}