package com.capgemini.makereservationservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.capgemini.makereservationservice.entity.Reservation;
import com.capgemini.makereservationservice.model.ReservationModel;

@Component
public class ReservationMapper {
	public Reservation mapDtoToEntity(ReservationModel model) {
		Reservation reservation = new Reservation();
		reservation.setCode(model.getCode());
		reservation.setNoOfChildren(model.getNoOfChildren());
		reservation.setNoOfAdult(model.getNoOfAdult());
		reservation.setCheckIn(model.getCheckIn());
		reservation.setCheckOut(model.getCheckOut());
		reservation.setStatus(model.getStatus());
		reservation.setNoOfNight(model.getNoOfNight());
		reservation.setRoomno(model.getRoomno());
		reservation.setGuestEmail(model.getGuestEmail());
		reservation.setGuestPhoneNo(model.getGuestPhoneNo());
		return reservation;
	}
	
	public ReservationModel mapEntityToDto(Reservation reservation) {
		ReservationModel model=new ReservationModel();
		BeanUtils.copyProperties(reservation, model);
		return model;
	}
}
