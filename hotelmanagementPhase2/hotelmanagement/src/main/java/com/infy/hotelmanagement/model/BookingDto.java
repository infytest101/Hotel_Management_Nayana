package com.infy.hotelmanagement.model;

import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Customer;

public class BookingDto {
	
	private String roomName;
	private BookingDetails bookingDetails;
	private Customer customer;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
