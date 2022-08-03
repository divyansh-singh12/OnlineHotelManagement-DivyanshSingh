package com.capgemini.makereservationservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.capgemini.makereservationservice.entity.Reservation;

@Repository
@EnableMongoRepositories
public interface ReservationRepository extends MongoRepository<Reservation, Integer> {
	@SuppressWarnings("unchecked")
	public Reservation save(Reservation reservation);

	public Reservation findById(int id);

	public List<Reservation> findAllByRoomnoAndStatus(int roomno, String status);

	public List<Reservation> findAll();

	public List<Reservation> findByRoomno(int roomno);

	public List<Reservation> findByOrderByRoomno();
}
