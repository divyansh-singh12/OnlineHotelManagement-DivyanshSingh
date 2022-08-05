package com.capgemini.manageroomservice.mapper;

import org.springframework.stereotype.Component;

import com.capgemini.manageroomservice.entity.Room;
import com.capgemini.manageroomservice.model.RoomModel;

@Component
public class RoomMapper {
	public Room mapDtoToEntity(RoomModel room) {
		Room roomEntity = new Room();
		roomEntity.setRoomno(room.getRoomno());
		roomEntity.setType(room.getType());
		roomEntity.setCapacity(room.getCapacity());
		roomEntity.setStatus(room.getStatus());
		roomEntity.setCheck_in_time(room.getCheck_in_time());
		roomEntity.setCheck_out_time(room.getCheck_out_time());
		roomEntity.setFirst_night_rate(room.getFirst_night_rate());
		roomEntity.setExtension_rate(room.getExtension_rate());
		roomEntity.setBookedtill(room.getBookedtill());
		return roomEntity;
	}

	public RoomModel mapEntityToDto(Room room) {
		RoomModel roomModel = new RoomModel();
		roomModel.setRoomno(room.getRoomno());
		roomModel.setType(room.getType());
		roomModel.setCapacity(room.getCapacity());
		roomModel.setStatus(room.getStatus());
		roomModel.setCheck_in_time(room.getCheck_in_time());
		roomModel.setCheck_out_time(room.getCheck_out_time());
		roomModel.setFirst_night_rate(room.getFirst_night_rate());
		roomModel.setExtension_rate(room.getExtension_rate());
		roomModel.setBookedtill(room.getBookedtill());
		return roomModel;
	}
}
