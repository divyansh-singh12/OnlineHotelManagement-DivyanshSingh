package com.capgemini.manageguestservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageguestservice.entity.Guest;
import com.capgemini.manageguestservice.model.GuestModel;

@Component
public class GuestMapper {
	@Autowired
	private AddressMapper addressMapper;

	public Guest mapDtoToEntity(GuestModel guest) {

		Guest guestEntity = new Guest();
		guestEntity.setId(guest.getId());
		guestEntity.setFirstName(guest.getFirstName());
		guestEntity.setLastName(guest.getLastName());
		guestEntity.setAddress(addressMapper.mapDtoToEntity(guest.getAddress()));
		guestEntity.setPhoneNumber(guest.getPhoneNumber());
		guestEntity.setCompany(guest.getCompany());
		guestEntity.setEmail(guest.getEmail());
		guestEntity.setGender(guest.getGender());
		return guestEntity;
	}

	public GuestModel mapEntityToDto(Guest guest) {
		GuestModel guestModel = new GuestModel();
		guestModel.setId(guest.getId());
		guestModel.setFirstName(guest.getFirstName());
		guestModel.setLastName(guest.getLastName());
		guestModel.setPhoneNumber(guest.getPhoneNumber());
		guestModel.setCompany(guest.getCompany());
		guestModel.setEmail(guest.getEmail());
		guestModel.setGender(guest.getGender());
		guestModel.setAddress(addressMapper.mapEntityToDto(guest.getAddress()));
		return guestModel;
	}
}
