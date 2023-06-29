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

import com.infy.hotelmanagement.exception.HotelManagementException;
import com.infy.hotelmanagement.model.RoomDto;
import com.infy.hotelmanagement.service.HotelmanagementService;

@RestController
@RequestMapping("/hotelmanagement")
public class HotelManagementController {

	@Autowired
	private HotelmanagementService hotelmanagementService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView room() {
		return new ModelAndView("room");
	}
	
	@RequestMapping(value = "/bookingListing", method = RequestMethod.GET)
	public ModelAndView booking() {
		return new ModelAndView("booking");
	}
	
	@RequestMapping(value = "/updateroom", method = RequestMethod.GET)
	public ModelAndView updateroom() {
		return new ModelAndView("NewFile2");
	}
	
	@RequestMapping(value = "/editRoom", method = RequestMethod.GET)
	public ModelAndView editRoom() {
		return new ModelAndView("editRoom");
	}
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.GET)
	public ModelAndView addRoom() {
		return new ModelAndView("addRoom");
	}
	
	@GetMapping(path = "/getrooms")
	public ResponseEntity<List<String>> getRooms() throws HotelManagementException{
		return new ResponseEntity<List<String>>(hotelmanagementService.getRoom(), HttpStatus.OK);
	}

	@GetMapping(path = "/getroomdetails")
	public ResponseEntity<List<RoomDto>> getRoomDetails(@RequestParam int id) throws HotelManagementException {
		return new ResponseEntity<List<RoomDto>>(hotelmanagementService.getRoomDetails(id), HttpStatus.OK);
	}

	@PostMapping(value = "/addOrUpdate")
	public ResponseEntity<String> addOrUpdate(@RequestBody RoomDto roomdto) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.addOrUpdate(roomdto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteRoom")
	public ResponseEntity<String> deleteRoom(@RequestParam int roomId) throws HotelManagementException {
		return new ResponseEntity<String>(hotelmanagementService.deleteRoom(roomId), HttpStatus.OK);
	}
}
