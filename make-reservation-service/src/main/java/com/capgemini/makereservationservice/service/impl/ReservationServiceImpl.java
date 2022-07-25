package com.capgemini.makereservationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capgemini.makereservationservice.entity.Reservation;
import com.capgemini.makereservationservice.mapper.ReservationMapper;
import com.capgemini.makereservationservice.model.BookData;
import com.capgemini.makereservationservice.model.ReservationModel;
import com.capgemini.makereservationservice.repository.ReservationRepository;
import com.capgemini.makereservationservice.service.ReservationService;

@Component
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired 
	private ReservationMapper reservationMapper;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public BookData doReservation(ReservationModel reservation) {
		Reservation reserved=reservationRepository.save(reservationMapper.mapDtoToEntity(reservation));
		BookData bookData=new BookData();
		bookData.setBookedTill(reserved.getCheckOut());
		bookData.setRoomNo(reserved.getRoomNo());
		return bookData;
	}
	
}
