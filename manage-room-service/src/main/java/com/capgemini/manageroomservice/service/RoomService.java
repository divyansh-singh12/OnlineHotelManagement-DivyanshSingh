package com.capgemini.manageroomservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.manageroomservice.model.RoomModel;
@Service
public interface RoomService {
	public RoomModel addRoomService(RoomModel room);
	public RoomModel updateRoomService(RoomModel room);
	public String deleteRoomService(int id);
	//public List<RoomModel> searchRoomService(int period,Date check_in, Date check_out,int no_of_guest);
	public String setRatesService(RoomModel room);
}
