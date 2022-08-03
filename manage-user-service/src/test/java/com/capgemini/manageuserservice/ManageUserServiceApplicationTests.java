package com.capgemini.manageuserservice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.manageuserservice.entity.User;
import com.capgemini.manageuserservice.repository.UserRepository;

@SpringBootTest
class ManageUserServiceApplicationTests {

	@Autowired
	UserRepository repo;

	@Test
	public void addTest() {
		User user = new User();
		user.setUsername("silentknight1010@gmail.com");
		user.setName("Divyansh");
		user.setPassword("Divyansh@123");
		user.setRole("ROLE_OWNER");
		repo.save(user);
		assertNotNull(repo.findByUsername("silentknight1010@gmail.com"));

	}

	@Test
	public void updateTest() {
		User user = repo.findByUsername("silentknight1010@gmail.com");
		user.setRole("ROLE_MANAGER");
		repo.save(user);
		assertNotEquals("ROLE_OWNER", repo.findByUsername("silentknight1010@gmail.com").getRole());
	}

	@Test
	public void viewTest() {
		assertEquals("Divyansh", repo.getUserByUsername("silentknight1010@gmail.com").getName());
	}

	@Test
	public void deleteTest() {
		repo.deleteById("silentknight1010@gmail.com");
		assertThat(repo.existsById("silentknight1010@gmail.com")).isFalse();

	}
}