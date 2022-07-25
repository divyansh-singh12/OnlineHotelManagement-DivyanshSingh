package com.capgemini.manageroomservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capgemini.manageroomservice.entity.Room;
import com.capgemini.manageroomservice.mapper.RoomMapper;
import com.capgemini.manageroomservice.model.BookData;
import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.repository.RoomRepository;
import com.capgemini.manageroomservice.service.RoomService;

@Component
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private RoomRepository roomRepository;
	
	public RoomModel addRoomService(RoomModel room) {
		Room roomEntity= roomRepository.save(roomMapper.mapDtoToEntity(room));
		return roomMapper.mapEntityToDto(roomEntity);
	}
	
	public RoomModel updateRoomService(RoomModel room) {
		Room roomEntity =roomRepository.findById(room.getRoom_no());
		roomEntity.setType(room.getType());
		roomEntity.setCapacity(room.getCapacity());
		roomEntity.setStatus(room.getStatus());
		roomEntity=roomRepository.save(roomEntity);
		return roomMapper.mapEntityToDto(roomEntity);
	}
	
	public String deleteRoomService(int room_no) {
		try {
			roomRepository.deleteById(room_no);
			return "Successfully deleted";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't delete";
	}
	
	public String setRatesService(RoomModel room) {
		try {
		List<Room> roomList = roomRepository.findAllByTypeAndCapacity(room.getType(), room.getCapacity());
		for (Room demoroom : roomList) {
			demoroom.setCheck_in_time(room.getCheck_in_time());
			demoroom.setCheck_out_time(room.getCheck_out_time());
			demoroom.setFirst_night_rate(room.getFirst_night_rate());
			demoroom.setExtension_rate(room.getExtension_rate());
			@SuppressWarnings("unused")
			Room lossdata=roomRepository.save(demoroom);
		}
		return "set rates done";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "can't set rates";
	}
	public String bookedRoom(BookData bookData) {
		Room roomEntity =roomRepository.findById(bookData.getRoomNo());
		roomEntity.setBookedtill(bookData.getBookedTill());
		roomEntity=roomRepository.save(roomEntity);
		return "Room Booked Successfully";
	}
}
