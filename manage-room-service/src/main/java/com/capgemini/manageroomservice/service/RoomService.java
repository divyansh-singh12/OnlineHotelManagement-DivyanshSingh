package com.capgemini.manageroomservice.service;

import org.springframework.stereotype.Service;

import com.capgemini.manageroomservice.model.BookData;
import com.capgemini.manageroomservice.model.RoomModel;
@Service
public interface RoomService {
	public RoomModel addRoomService(RoomModel room);
	public RoomModel updateRoomService(RoomModel room);
	public String deleteRoomService(int id);
	public String setRatesService(RoomModel room);
	public String bookedRoom(BookData bookData);
}
