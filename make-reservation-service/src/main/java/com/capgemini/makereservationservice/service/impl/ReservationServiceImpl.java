package com.capgemini.makereservationservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		Random rd = new Random();
		reservation.setCode(rd.nextInt(Integer.MAX_VALUE));
		Reservation reserved=reservationRepository.save(reservationMapper.mapDtoToEntity(reservation));
		BookData bookData=new BookData();
		bookData.setBookedTill(reserved.getCheckOut());
		bookData.setRoomNo(reserved.getRoomno());
		return bookData;
	}
	
	public List<ReservationModel> findallBookings(){
		List<Reservation> reservationList= reservationRepository.findByOrderByRoomno();
		List<ReservationModel> modelList= new ArrayList<ReservationModel>();
		for(Reservation booking: reservationList) {
			modelList.add(reservationMapper.mapEntityToDto(booking));
		}
		return modelList;
		}
	public List<ReservationModel> findBookingsOfRoom(int roomno){
		List<Reservation> reservationList= reservationRepository.findByRoomno(roomno);
		List<ReservationModel> modelList= new ArrayList<ReservationModel>();
		for(Reservation booking: reservationList) {
			modelList.add(reservationMapper.mapEntityToDto(booking));
		}
		return modelList;
	}
}
