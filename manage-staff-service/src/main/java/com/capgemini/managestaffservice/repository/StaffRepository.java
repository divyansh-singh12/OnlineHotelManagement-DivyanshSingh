package com.capgemini.managestaffservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.managestaffservice.entity.Staff;

@Repository
@EnableJpaRepositories
public interface StaffRepository extends JpaRepository<Staff,Integer> {
	public List<Staff> findAll();
	
	@SuppressWarnings("unchecked")
	public Staff save(Staff staff);
	
	public void deleteById(int id);
	
	public Staff findById(int id);
}
