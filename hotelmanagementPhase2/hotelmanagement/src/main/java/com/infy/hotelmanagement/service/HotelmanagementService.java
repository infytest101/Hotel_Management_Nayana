package com.infy.hotelmanagement.service;

import java.util.List;

import com.infy.hotelmanagement.entity.Room;
import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.BookingDto;
import com.infy.hotelmanagement.model.RoomDto;

public interface HotelmanagementService {
	
	public List<String> getRoom() throws HotelManagementException;

	public List<Room> getRoomDetails(int id) throws HotelManagementException;

	public String addOrUpdate( RoomDto roomdto)throws HotelManagementException;

	public String deleteRoom(int roomId)throws HotelManagementException;

	public String bookRoom(BookingDto bookingDto)throws HotelManagementException ;

	public List<String> getRoomNames()throws HotelManagementException ;

	public String updateRoom(BookingDto bookingDto)throws HotelManagementException ;

}
