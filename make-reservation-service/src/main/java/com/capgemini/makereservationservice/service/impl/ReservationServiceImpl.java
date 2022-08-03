package com.capgemini.makereservationservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

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
		validateEntity(reservation);
		Random rd = new Random();
		reservation.setCode(rd.nextInt(Integer.MAX_VALUE));
		Reservation reserved = reservationRepository.save(reservationMapper.mapDtoToEntity(reservation));
		BookData bookData = new BookData();
		bookData.setBookedTill(reserved.getCheckOut());
		bookData.setRoomNo(reserved.getRoomno());
		return bookData;
	}

	public List<ReservationModel> findallBookings() {
		List<Reservation> reservationList = reservationRepository.findByOrderByRoomno();
		List<ReservationModel> modelList = new ArrayList<ReservationModel>();
		for (Reservation booking : reservationList) {
			modelList.add(reservationMapper.mapEntityToDto(booking));
		}
		return modelList;
	}

	public List<ReservationModel> findBookingsOfRoom(int roomno) {
		List<Reservation> reservationList = reservationRepository.findByRoomno(roomno);
		List<ReservationModel> modelList = new ArrayList<ReservationModel>();
		for (Reservation booking : reservationList) {
			modelList.add(reservationMapper.mapEntityToDto(booking));
		}
		return modelList;
	}

	private void validateEntity(ReservationModel reservation) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<ReservationModel>> constraintViolations = validator.validate(reservation);

		for (ConstraintViolation<ReservationModel> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}
}
