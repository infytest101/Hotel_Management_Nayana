package com.infy.hotelmanagement.service;

import java.util.List;

import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.RoomDto;

public interface HotelmanagementService {
	
	public List<String> getRoom() throws HotelManagementException;

	public List<RoomDto> getRoomDetails(int id) throws HotelManagementException;

	public String addOrUpdate( RoomDto roomdto)throws HotelManagementException;

	public String deleteRoom(int roomId)throws HotelManagementException; 

}
