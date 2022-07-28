package com.capgemini.manageroomservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.capgemini.manageroomservice.entity.Room;

@Repository
@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<Room, Integer> {
	public List<Room> findAll();
	
	@SuppressWarnings("unchecked")
	public Room save(Room room);
	public void deleteById(int roomno);
	public void delete (Room room);
	public Room findById(int id);
	
	public List<Room> findAllByTypeAndCapacity(String type, int capacity);
	public List<Room> findByStatus(String status);
	public Room findByRoomno (int roomno);
}
