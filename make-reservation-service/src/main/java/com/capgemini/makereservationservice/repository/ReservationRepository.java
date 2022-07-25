package com.capgemini.makereservationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.makereservationservice.entity.Reservation;

@Repository
@EnableMongoRepositories
public interface ReservationRepository extends MongoRepository<Reservation,Integer>{
	@SuppressWarnings("unchecked")
	public Reservation save(Reservation reservation);
	public Reservation findById(int id);
}
