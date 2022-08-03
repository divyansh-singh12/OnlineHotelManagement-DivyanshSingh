package com.capgemini.manageroomservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.manageroomservice.entity.Room;
import com.capgemini.manageroomservice.mapper.RoomMapper;
import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.model.SearchModel;
import com.capgemini.manageroomservice.repository.RoomRepository;
import com.capgemini.manageroomservice.service.SearchService;

@Component
public class SearchServiceImpl implements SearchService {
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<RoomModel> searchRoomService(SearchModel searchQuery) {
		List<Room> roomlist = roomRepository.findAllByTypeAndCapacity(searchQuery.getType(),
				searchQuery.getNo_of_guest());
		List<RoomModel> modelList = new ArrayList<RoomModel>();
		for (Room room : roomlist) {
			if (room.getStatus().equalsIgnoreCase("available")
					&& searchQuery.getCheck_in().after(room.getBookedtill())) {
				modelList.add(roomMapper.mapEntityToDto(room));
			}
		}
		return modelList;
	}

}
