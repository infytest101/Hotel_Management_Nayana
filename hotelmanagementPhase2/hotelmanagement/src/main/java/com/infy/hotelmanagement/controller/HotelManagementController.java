package com.infy.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.infy.hotelmanagement.entity.Room;
import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.BookingDto;
import com.infy.hotelmanagement.model.RoomDto;
import com.infy.hotelmanagement.service.HotelmanagementService;

@RestController
//@RequestMapping("/hotelmanagement")
public class HotelManagementController {

	@Autowired
	private HotelmanagementService hotelmanagementService;

	@RequestMapping(value = "/hotelmanagement/", method = RequestMethod.GET)
	public ModelAndView room() {
		return new ModelAndView("room");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/hotelmanagement/bookingListing", method = RequestMethod.GET)
	public ModelAndView booking() {
		return new ModelAndView("booking");
	}

	@RequestMapping(value = "/hotelmanagement/editRoom", method = RequestMethod.GET)
	public ModelAndView editRoom() {
		return new ModelAndView("editRoom");
	}

	@RequestMapping(value = "/hotelmanagement/addRoom", method = RequestMethod.GET)
	public ModelAndView addRoom() {
		return new ModelAndView("addRoom");
	}

	@GetMapping(path = "/hotelmanagement/getrooms")
	public ResponseEntity<List<String>> getRooms() throws HotelManagementException {
		return new ResponseEntity<List<String>>(hotelmanagementService.getRoom(), HttpStatus.OK);
	}

	@GetMapping(path = "/hotelmanagement/getroomdetails")
	public ResponseEntity<List<Room>> getRoomDetails(@RequestParam int id) throws HotelManagementException {
		return new ResponseEntity<List<Room>>(hotelmanagementService.getRoomDetails(id), HttpStatus.OK);
	}

	@PostMapping(value = "/hotelmanagement/addOrUpdate")
	public ResponseEntity<String> addOrUpdate(@RequestBody RoomDto roomdto) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.addOrUpdate(roomdto), HttpStatus.OK);
	}

	@PostMapping(value = "/hotelmanagement/bookRoom")
	public ResponseEntity<String> bookRoom(@RequestBody BookingDto bookingDto) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.bookRoom(bookingDto), HttpStatus.OK);
	}

	@DeleteMapping(value = "/hotelmanagement/deleteRoom")
	public ResponseEntity<String> deleteRoom(@RequestParam int roomId) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.deleteRoom(roomId), HttpStatus.OK);
	}

	@GetMapping(path = "/hotelmanagement/getRoomNames")
	public ResponseEntity<List<String>> getRoomNames() throws HotelManagementException {
		return new ResponseEntity<List<String>>(hotelmanagementService.getRoomNames(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/hotelmanagement/updateRoom")
	public ResponseEntity<String> updateRoom(@RequestBody BookingDto bookingDto) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.updateRoom(bookingDto), HttpStatus.OK);
	}
}
