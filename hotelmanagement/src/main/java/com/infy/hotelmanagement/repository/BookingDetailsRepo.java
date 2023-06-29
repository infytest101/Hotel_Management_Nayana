package com.infy.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Room;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Integer>{

	void deleteByRoom(Room room);
	

}
