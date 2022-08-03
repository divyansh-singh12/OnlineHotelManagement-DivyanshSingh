package com.capgemini.retrievereportservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.retrievereportservice.entity.StaffPaymentReport;

@Repository
@EnableMongoRepositories
public interface StaffReportRepository extends MongoRepository<StaffPaymentReport, Integer> {
	public List<StaffPaymentReport> findAll();

	@SuppressWarnings("unchecked")
	public StaffPaymentReport save(StaffPaymentReport staff);

	public void deleteAll();

	@Aggregation(pipeline = { "{$group: { _id: '', total: {$sum: $salary}}}" })
	public double sumSalary();

}