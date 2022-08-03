package com.capgemini.manageguestservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.manageguestservice.model.GuestModel;

@Service
public interface GuestService {

	public GuestModel addGuestService(GuestModel guest);

	public GuestModel updateGuestService(GuestModel guest);

	public GuestModel viewGuestService(int id);

	public GuestModel viewGuestService(String email);

}