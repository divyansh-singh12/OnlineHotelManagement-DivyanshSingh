package com.capgemini.manageguestservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageguestservice.entity.Guest;
import com.capgemini.manageguestservice.mapper.AddressMapper;
import com.capgemini.manageguestservice.mapper.GuestMapper;
import com.capgemini.manageguestservice.model.AddressModel;
import com.capgemini.manageguestservice.model.GuestModel;
import com.capgemini.manageguestservice.repository.GuestRepository;
import com.capgemini.manageguestservice.service.GuestService;

@Component
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestMapper guestMapper;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private GuestRepository guestRepository;

	public GuestModel addGuestService(GuestModel guest) {
		validateEntity(guest.getAddress());
		validateEntity(guest);
		Guest guestEntity = guestRepository.save(guestMapper.mapDtoToEntity(guest));
		return guestMapper.mapEntityToDto(guestEntity);
	}

	public GuestModel updateGuestService(GuestModel guest) {
		validateEntity(guest.getAddress());
		validateEntity(guest);
		Guest guestEntity = guestRepository.findById(guest.getId());

		guestEntity.setFirstName(guest.getFirstName());
		guestEntity.setLastName(guest.getLastName());
		guestEntity.setAddress(addressMapper.mapDtoToEntity(guest.getAddress()));
		guestEntity.setPhoneNumber(guest.getPhoneNumber());
		guestEntity.setCompany(guest.getCompany());
		guestEntity.setEmail(guest.getEmail());
		guestEntity.setGender(guest.getGender());
		guestEntity = guestRepository.save(guestEntity);
		return guestMapper.mapEntityToDto(guestEntity);
	}

	public GuestModel viewGuestService(int id) {
		Guest guestEntity = guestRepository.findById(id);
		return guestMapper.mapEntityToDto(guestEntity);

	}

	public GuestModel viewGuestService(String email) {
		Guest guestEntity = guestRepository.findByEmail(email);
		return guestMapper.mapEntityToDto(guestEntity);
	}

	private void validateEntity(GuestModel guest) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<GuestModel>> constraintViolations = validator.validate(guest);

		for (ConstraintViolation<GuestModel> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	private void validateEntity(AddressModel address) {
		List<String> errorMessage = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<AddressModel>> constraintViolations = validator.validate(address);

		for (ConstraintViolation<AddressModel> constraintViolation : constraintViolations) {
			errorMessage.add(constraintViolation.getMessage());
		}

		if (errorMessage.size() > 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}
}
