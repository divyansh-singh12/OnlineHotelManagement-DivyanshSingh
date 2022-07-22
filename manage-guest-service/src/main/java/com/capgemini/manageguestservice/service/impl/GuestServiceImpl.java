package com.capgemini.manageguestservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageguestservice.entity.Guest;
import com.capgemini.manageguestservice.mapper.AddressMapper;
import com.capgemini.manageguestservice.mapper.GuestMapper;
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
		Guest guestEntity = guestRepository.save(guestMapper.mapDtoToEntity(guest));
		return guestMapper.mapEntityToDto(guestEntity);
	}

	
	public GuestModel updateGuestService(GuestModel guest) {
		Guest guestEntity = guestRepository.findById(guest.getId());

		guestEntity.setFirstName(guest.getFirstName());
		guestEntity.setLastName(guest.getLastName());
		guestEntity.setAddress(addressMapper.mapDtoToEntity(guest.getAddress()));
		guestEntity.setPhoneNumber(guest.getPhoneNumber());
		guestEntity.setCompany(guest.getCompany());
		guestEntity.setEmail(guest.getEmail());
		guestEntity.setGender(guest.getGender());
		guestEntity=guestRepository.save(guestEntity);
		return guestMapper.mapEntityToDto(guestEntity);
	}

	
	public GuestModel viewGuestService(int id) {
		Guest guestEntity = guestRepository.findById(id);
		return guestMapper.mapEntityToDto(guestEntity);
		
		
	}


}
