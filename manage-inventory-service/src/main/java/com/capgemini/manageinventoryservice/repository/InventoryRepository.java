package com.capgemini.manageinventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.manageinventoryservice.entity.Inventory;

@Repository
@EnableJpaRepositories
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	public List<Inventory> findAll();

	@SuppressWarnings("unchecked")
	public Inventory save(Inventory inventory);

	public void deleteById(int id);

	public Inventory findById(int id);

	public Inventory findByItemname(String itemname);

}
