package com.capgemini.makereservationservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.makereservationservice.entity.Bill;

@Repository
@EnableMongoRepositories
public interface BillRepository extends MongoRepository<Bill,Integer> {
	@SuppressWarnings("unchecked")
	public Bill save(Bill bill);
	public Bill findById(int billid);
	public List<Bill> findAll();
}
