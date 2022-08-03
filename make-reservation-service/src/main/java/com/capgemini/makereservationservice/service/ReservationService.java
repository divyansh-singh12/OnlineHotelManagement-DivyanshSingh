package com.capgemini.makereservationservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.makereservationservice.model.BookData;
import com.capgemini.makereservationservice.model.ReservationModel;

@Service
public interface ReservationService {
	public BookData doReservation(ReservationModel reservation);

	public List<ReservationModel> findallBookings();

	public List<ReservationModel> findBookingsOfRoom(int roomno);
}
