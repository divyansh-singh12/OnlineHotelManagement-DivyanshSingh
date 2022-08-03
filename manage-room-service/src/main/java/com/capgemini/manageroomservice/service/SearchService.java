package com.capgemini.manageroomservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.model.SearchModel;

@Service
public interface SearchService {
	public List<RoomModel> searchRoomService(SearchModel searchQuery);
}
