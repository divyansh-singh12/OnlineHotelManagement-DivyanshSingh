package com.capgemini.manageuserservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.manageuserservice.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String>{
	
public List<User> findAll();
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
	public void deleteById(String username);
	
	public User findByUsername(String username);
	
	@Query("select u from User u where u.username = :email")
	public User getUserByUsername(@Param("email") String email);
	
	
	
	
		
}