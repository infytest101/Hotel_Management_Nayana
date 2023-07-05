package com.infy.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.hotelmanagement.entity.Room;

@Repository
public interface HotelmanagementRepo extends JpaRepository<Room, Integer>{

	Room findByRoomName(String roomName);

}
