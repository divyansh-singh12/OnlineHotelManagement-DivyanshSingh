package com.capgemini.manageguestservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.manageguestservice.entity.Guest;

@Repository
@EnableJpaRepositories
public interface GuestRepository extends JpaRepository<Guest, Integer> {

	public List<Guest> findAll();

	@SuppressWarnings("unchecked")
	public Guest save(Guest guest);

	public Guest findById(int id);

	public Guest findByEmail(String Email);
}