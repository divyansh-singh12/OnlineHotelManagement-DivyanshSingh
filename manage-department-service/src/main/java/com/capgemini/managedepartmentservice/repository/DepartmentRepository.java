package com.capgemini.managedepartmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.managedepartmentservice.entity.Department;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public List<Department> findAll();

	@SuppressWarnings("unchecked")
	public Department save(Department department);

	public void deleteById(int id);

	public Department findById(int id);

	public Department findByName(String name);

}
