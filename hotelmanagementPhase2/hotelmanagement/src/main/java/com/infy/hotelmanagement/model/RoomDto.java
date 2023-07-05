package com.infy.hotelmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.hotelmanagement.entity.Amenities;
import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Customer;
import com.infy.hotelmanagement.entity.Roomtype;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDto {

	private int roomId;

	private Roomtype roomType;

	private Amenities amenities;

	private int price;

	private String editOrAdd;

	private BookingDetails bookingDetails;

	private Customer customer;

	private String roomName;

	private int totalRoomsAvailable;

	public RoomDto() {
		super();
	}

	public RoomDto(int roomId, Roomtype roomType, Amenities amenities, int price, String editOrAdd,
			BookingDetails bookingDetails, Customer customer, String roomName, int totalRoomsAvailable) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.amenities = amenities;
		this.price = price;
		this.editOrAdd = editOrAdd;
		this.bookingDetails = bookingDetails;
		this.customer = customer;
		this.roomName = roomName;
		this.totalRoomsAvailable = totalRoomsAvailable;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Roomtype getRoomType() {
		return roomType;
	}

	public void setRoomType(Roomtype roomType) {
		this.roomType = roomType;
	}

	public Amenities getAmenities() {
		return amenities;
	}

	public void setAmenities(Amenities amenities) {
		this.amenities = amenities;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEditOrAdd() {
		return editOrAdd;
	}

	public void setEditOrAdd(String editOrAdd) {
		this.editOrAdd = editOrAdd;
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getTotalRoomsAvailable() {
		return totalRoomsAvailable;
	}

	public void setTotalRoomsAvailable(int totalRoomsAvailable) {
		this.totalRoomsAvailable = totalRoomsAvailable;
	}

}
