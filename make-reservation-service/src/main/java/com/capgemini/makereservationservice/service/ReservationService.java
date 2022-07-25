package com.capgemini.makereservationservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.makereservationservice.model.BookData;
import com.capgemini.makereservationservice.model.ReservationModel;

@Service
public interface ReservationService {
	public BookData doReservation(ReservationModel reservation);
}
