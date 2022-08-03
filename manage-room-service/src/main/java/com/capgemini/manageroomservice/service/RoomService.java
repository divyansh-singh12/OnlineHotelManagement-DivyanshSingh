package com.capgemini.manageroomservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.manageroomservice.model.BookData;
import com.capgemini.manageroomservice.model.*;

@Service
public interface RoomService {
	public RoomModel addRoomService(AddRoomModel room);

	public RoomModel updateRoomService(AddRoomModel room);

	public String deleteRoomService(int roomno);

	public String setRatesService(SetRatesModel room);

	public String bookedRoom(BookData bookData);

	public RoomModel viewroom(int roomno);
}
