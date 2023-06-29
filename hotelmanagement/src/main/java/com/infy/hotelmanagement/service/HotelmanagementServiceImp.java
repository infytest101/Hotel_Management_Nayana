package com.infy.hotelmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.hotelmanagement.HotelmanagementApplication;
import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Room;
import com.infy.hotelmanagement.entity.Roomtype;
import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.RoomDto;
import com.infy.hotelmanagement.repository.BookingDetailsRepo;
import com.infy.hotelmanagement.repository.HotelmanagementRepo;
import com.infy.hotelmanagement.repository.ListingRoomRepo;

@Service
public class HotelmanagementServiceImp implements HotelmanagementService {

	@Autowired
	private HotelmanagementRepo hotelmanagementRepo;

	@Autowired
	private ListingRoomRepo listingRoomRepo;

	@Autowired
	private BookingDetailsRepo bookingDetailsRepo;

	private static final Logger logger = LoggerFactory.getLogger(HotelmanagementApplication.class);

	@Override
	public List<String> getRoom() throws HotelManagementException {
		List<String> results = new ArrayList<>();
		try {
			logger.info("Started Fetching Room Types");
			results = listingRoomRepo.findAll().stream().flatMap(a -> a.getRoomType().lines()).distinct()
					.collect(Collectors.toList());
			if (results.isEmpty())
				throw new HotelManagementException("Can't able to fetch room type or no room type exists");
			logger.info("Completed Fetching Room Types::" + results);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return results;
	}

	@Override
	public List<RoomDto> getRoomDetails(int id) throws HotelManagementException {
		List<Room> results = new ArrayList<>();
		List<RoomDto> roomdtoList = new ArrayList<>();
		try {
			logger.info("Started Fetching Room Details");
			if (id != 0) {
				results.add(hotelmanagementRepo.findById(id).get());
			} else {
				results = hotelmanagementRepo.findAll();
			}
			if (results.isEmpty())
				throw new HotelManagementException("Can't able to fetch room details or no room details exists");
			for (Room result : results) {
				RoomDto roomDto = new RoomDto();
				roomDto.setRoomId(result.getRoomId());
				roomDto.setRoomType(result.getRoomtype());
				roomDto.setPrice(result.getPrice());
				roomDto.setRoomtypeid(result.getRoomtypeid());
				roomDto.setSmokingOrNonSmoking(result.getIsSmokingAvailable());
				roomDto.setAcOrNonAC(result.getIsACAvailable());
				JSONObject jObject = new JSONObject(result.getAmenties().toString());
				roomDto.setAmenties("SmokingOrNonSmoking : " + jObject.getString("smokingOrNonSmoking") + "\n "
						+ "WifiTvGeyser : " + jObject.getString("wifiTvGeyser") + "\n" + "AcOrNonAC : "
						+ jObject.getString("acOrNonAC"));
				roomDto.setWifiTvGeyser(jObject.get("wifiTvGeyser").toString());
				roomDto.setBookingDetails(result.getBookingDetails().get(0));
				roomDto.setTotalRoomAvailable(result.getTotalRoomAvailable());
				roomDto.setTotalRoomBooked(result.getTotalRoomBooked());
				roomdtoList.add(roomDto);
			}
			logger.info("Completed Fetching Room Details");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return roomdtoList;
	}

	@Override
	public String addOrUpdate(RoomDto roomdto) throws HotelManagementException{
		Room rooms = new Room();
		BookingDetails bookingDetails = new BookingDetails();
		String message = "";
		JSONObject jsonString = new JSONObject();
		try {
			if (roomdto.getEditOrDelete().equalsIgnoreCase("edit")) {
				logger.info("Starting Updating Room Details");
				Optional<Room> roomAvailability = hotelmanagementRepo.findById(roomdto.getRoomId());
				if (roomAvailability.isPresent()) {
					getRoomData(roomdto, rooms, jsonString);
					rooms.setRoomId(roomdto.getRoomId());
					hotelmanagementRepo.save(rooms);
					bookingDetails.setBookingdatestart(roomdto.getBookingDetails().getBookingdatestart());
					bookingDetails.setBookingdateend(roomdto.getBookingDetails().getBookingdateend());
					bookingDetails.setBookingdetailsid(roomdto.getBookingDetails().getBookingdetailsid());
					bookingDetails.setRoom(rooms);
					bookingDetailsRepo.save(bookingDetails);
					message = "Edited Successfully";
					logger.info("Completed Updating Room Details");
				} else {
					message = "RoomId not present";
					logger.error("RoomId not present::" + roomdto.getRoomId());
					throw new HotelManagementException(message);
				}

			} else {
				if (roomdto.getEditOrDelete().equalsIgnoreCase("add")) {
					logger.info("Starting Addiing Room Details");
					getRoomData(roomdto, rooms, jsonString);
					Room room = hotelmanagementRepo.save(rooms);
//					bookingDetails.setBookingdatestart(roomdto.getBookingDetails().getBookingdatestart());
//					bookingDetails.setBookingdateend(roomdto.getBookingDetails().getBookingdateend());
					bookingDetails.setRoom(room);
					bookingDetailsRepo.save(bookingDetails);
					message = "Added Successfully";
					logger.info("Completed Adding Room Details");
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}

		return message;
	}

	private void getRoomData(RoomDto roomdto, Room rooms, JSONObject jsonString) {
		jsonString.put("smokingOrNonSmoking", roomdto.getSmokingOrNonSmoking());
		jsonString.put("acOrNonAC", roomdto.getAcOrNonAC());
		jsonString.put("wifiTvGeyser", roomdto.getWifiTvGeyser());
		rooms.setPrice(roomdto.getPrice());
		rooms.setIsACAvailable(roomdto.getAcOrNonAC());
		rooms.setIsSmokingAvailable(roomdto.getSmokingOrNonSmoking());
		rooms.setRoomtype(roomdto.getRoomType());
		rooms.setAmenties(jsonString.toString());
		rooms.setTotalRoomAvailable(roomdto.getTotalRoomAvailable());
		rooms.setTotalRoomBooked(roomdto.getTotalRoomBooked());
	}

	@Override
	public String deleteRoom(int roomId) throws HotelManagementException{
		String message = "";
		try {
			logger.info("Starting Deleting Room");
			Room room = hotelmanagementRepo.findById(roomId).get();
			int roomTypeId = room.getRoomtypeid();
			LocalDate bookingEndDate = room.getBookingDetails().get(0).getBookingdateend();
			LocalDate currentDate = LocalDate.now();
//			if (!bookingEndDate.isAfter(currentDate) || bookingEndDate.isEqual(currentDate)) {
			if (room.getTotalRoomAvailable() > room.getTotalRoomBooked()) {
				bookingDetailsRepo.deleteById(room.getBookingDetails().get(0).getBookingdetailsid());
				hotelmanagementRepo.deleteById(roomId);
				listingRoomRepo.deleteById(roomTypeId);
				message = "Deleted Successfully";
				logger.info("Completed Deleting Room");
			} else {
				message = "Cant't able to delete room";
				logger.info("Cant't able to delete room");
				throw new HotelManagementException(message);
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return message;
	}

}
