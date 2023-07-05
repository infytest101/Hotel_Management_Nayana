package com.infy.hotelmanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.hotelmanagement.HotelmanagementApplication;
import com.infy.hotelmanagement.entity.Amenities;
import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Customer;
import com.infy.hotelmanagement.entity.Room;
import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.BookingDto;
import com.infy.hotelmanagement.model.RoomDto;
import com.infy.hotelmanagement.repository.BookingDetailsRepo;
import com.infy.hotelmanagement.repository.CutomerRepo;
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

	@Autowired
	private CutomerRepo cutomerRepo;

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
	public List<Room> getRoomDetails(int id) throws HotelManagementException {
		List<Room> results = new ArrayList<>();
		try {
			logger.info("Started Fetching Room Details");
			if (id != 0) {
				results.add(hotelmanagementRepo.findById(id).get());
				logger.info("Completed Fetching Room Details");
			} else {
				results = hotelmanagementRepo.findAll();
				logger.info("Completed Fetching Room Details");
			}
			if (results.isEmpty())
				throw new HotelManagementException("Can't able to fetch room details or no room details exists");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return results;
	}

	@Override
	public String addOrUpdate(RoomDto roomdto) throws HotelManagementException {
		Room room = new Room();
		String message = "";
		try {
			if (roomdto.getEditOrAdd().equalsIgnoreCase("edit")) {
				logger.info("Starting Updating Room Details");
				Optional<Room> roomAvailability = hotelmanagementRepo.findById(roomdto.getRoomId());
				if (roomAvailability.isPresent()) {
					room.setRoomId(roomdto.getRoomId());
					room.setRoomTypeId(roomAvailability.get().getRoomTypeId());
					room.setAmenitiesId(roomAvailability.get().getAmenitiesId());
					roomdto.getAmenities().setAmenitiesId(roomAvailability.get().getAmenitiesId());
					roomdto.getRoomType().setRoomTypeId(roomAvailability.get().getRoomTypeId());
					room.setAmenities(roomdto.getAmenities());
					room.setCreateBy(roomAvailability.get().getCreateBy());
					room.setCreateDate(roomAvailability.get().getCreateDate());
					room.setRoomtype(roomdto.getRoomType());
					room.setPrice(roomdto.getPrice());
					room.setRoomName(roomdto.getRoomName());
					room.setTotalRoomsAvailable(roomdto.getTotalRoomsAvailable());
					room.setUpdatedBy("Nayana M");
					room.setUpdateDate(LocalDateTime.now());
					hotelmanagementRepo.save(room);
					message = "Edited Successfully";
					logger.info("Completed Updating Room Details");
				} else {
					message = "RoomId not present";
					logger.error("RoomId not present::" + roomdto.getRoomId());
					throw new HotelManagementException(message);
				}

			} else {
				if (roomdto.getEditOrAdd().equalsIgnoreCase("add")) {
					room.setAmenities(roomdto.getAmenities());
					room.setRoomtype(roomdto.getRoomType());
					room.setPrice(roomdto.getPrice());
					room.setRoomName(roomdto.getRoomName());
					room.setCreateBy("Nayana M");
					room.setCreateDate(LocalDateTime.now());
					room.setTotalRoomsAvailable(roomdto.getTotalRoomsAvailable());
					hotelmanagementRepo.save(room);
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

	@Override
	public String deleteRoom(int roomId) throws HotelManagementException {
		String message = "";
		try {
			logger.info("Starting Deleting Room");
			Room room = hotelmanagementRepo.findById(roomId).get();
			BookingDetails bookingDetails = bookingDetailsRepo.findByRoomId(roomId);
			int roomTypeId = room.getRoomTypeId();
			LocalDate bookingEndDate = bookingDetails.getBookingDateEnd();
			LocalDate currentDate = LocalDate.now();
			if (!bookingEndDate.isAfter(currentDate) || bookingEndDate.isEqual(currentDate)) {
				bookingDetailsRepo.deleteByBookingDetailsId(bookingDetails.getBookingDetailsId());
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
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return message;
	}

	@Override
	public String bookRoom(BookingDto bookingDto) throws HotelManagementException {
		String message = "";
		try {
			logger.info("Started Booking Room");
			Room room = hotelmanagementRepo.findByRoomName(bookingDto.getRoomName());
			Customer customer = cutomerRepo.save(bookingDto.getCustomer());
			bookingDto.getBookingDetails().setRoomId(room.getRoomId());
			bookingDto.getBookingDetails().setCustomerId(customer.getCustomerId());
			bookingDto.getBookingDetails().setCreateBy("Nayana M");
			bookingDto.getBookingDetails().setCreateDate(LocalDateTime.now());
			bookingDetailsRepo.save(bookingDto.getBookingDetails());
			room.setTotalRoomsAvailable(
					room.getTotalRoomsAvailable() - bookingDto.getBookingDetails().getTotalRoomsBooked());
			hotelmanagementRepo.save(room);
			message = "Hotel Room Booked Successfully";
			logger.info("Completed Booking Room");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<String> getRoomNames() throws HotelManagementException {
		List<String> roomNames = new ArrayList<String>();
		try {
			logger.info("Started fetching room name");
			roomNames = hotelmanagementRepo.findAll().stream().flatMap(a -> a.getRoomName().lines()).toList();
			logger.info("Completed fetching room name");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return roomNames;
	}

	@Override
	public String updateRoom(BookingDto bookingDto) throws HotelManagementException {
		String message = "";
		try {
			logger.info("Started Updating Booked Room");
			BookingDetails bookingDetails=bookingDetailsRepo.findByBookingDetailsId(bookingDto.getBookingDetails().getBookingDetailsId());
			bookingDto.getCustomer().setCustomerId(bookingDetails.getCustomerId());
			cutomerRepo.save(bookingDto.getCustomer());
			bookingDto.getBookingDetails().setUpdatedBy("Nayana M");
			bookingDto.getBookingDetails().setUpdateDate(LocalDateTime.now());
			bookingDetailsRepo.save(bookingDto.getBookingDetails());
			Optional<Room> room=hotelmanagementRepo.findById(bookingDetails.getRoomId());
			room.get().setTotalRoomsAvailable(
					room.get().getTotalRoomsAvailable() - bookingDto.getBookingDetails().getTotalRoomsBooked());
			hotelmanagementRepo.save(room.get());
			message = "Hotel Room Updated Successfully";
			logger.info("Completed Updating Booked Room");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HotelManagementException(e.getMessage());
		}
		return message;
	}

}
