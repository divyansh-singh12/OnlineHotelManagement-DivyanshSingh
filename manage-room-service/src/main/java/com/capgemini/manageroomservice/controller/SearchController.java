package com.capgemini.manageroomservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageroomservice.model.RoomModel;
import com.capgemini.manageroomservice.model.SearchModel;
import com.capgemini.manageroomservice.service.SearchService;

@RestController
@RequestMapping("/SearchRoom")
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@GetMapping(value="/result", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoomModel>> searchRoom(@RequestBody SearchModel searchQuery){
		return ResponseEntity.ok(searchService.searchRoomService(searchQuery));
		}
	
}
