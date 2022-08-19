package com.capgemini.manageuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.manageuserservice.entity.Jwt;

@Repository
@EnableJpaRepositories
public interface JwtRepository extends JpaRepository<Jwt, Integer>{

	@SuppressWarnings("unchecked")
	public Jwt save(Jwt jwt);

	public void deleteById(int id);

	public Jwt findById(int id);
}
