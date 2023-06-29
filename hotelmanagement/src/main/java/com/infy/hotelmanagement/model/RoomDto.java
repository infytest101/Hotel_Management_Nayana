package com.infy.hotelmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.hotelmanagement.entity.BookingDetails;
import com.infy.hotelmanagement.entity.Roomtype;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDto {

	private int roomId;

	private int roomtypeid;

	private Roomtype roomType;

	private String acOrNonAC;

	private String smokingOrNonSmoking;

	private String wifiTvGeyser;

	private int price;

	private String editOrDelete;

	private BookingDetails bookingDetails;

	private String amenties;

	private int totalRoomAvailable;

	private int totalRoomBooked;

	public RoomDto() {
		super();
	}

	public RoomDto(int roomId, int roomtypeid, Roomtype roomType, String acOrNonAC, String smokingOrNonSmoking,
			String wifiTvGeyser, int price, String editOrDelete, BookingDetails bookingDetails, String amenties,
			int totalRoomAvailable, int totalRoomBooked) {
		super();
		this.roomId = roomId;
		this.roomtypeid = roomtypeid;
		this.roomType = roomType;
		this.acOrNonAC = acOrNonAC;
		this.smokingOrNonSmoking = smokingOrNonSmoking;
		this.wifiTvGeyser = wifiTvGeyser;
		this.price = price;
		this.editOrDelete = editOrDelete;
		this.bookingDetails = bookingDetails;
		this.amenties = amenties;
		this.totalRoomAvailable = totalRoomAvailable;
		this.totalRoomBooked = totalRoomBooked;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomtypeid() {
		return roomtypeid;
	}

	public void setRoomtypeid(int roomtypeid) {
		this.roomtypeid = roomtypeid;
	}

	public Roomtype getRoomType() {
		return roomType;
	}

	public void setRoomType(Roomtype roomType) {
		this.roomType = roomType;
	}

	public String getAcOrNonAC() {
		return acOrNonAC;
	}

	public void setAcOrNonAC(String acOrNonAC) {
		this.acOrNonAC = acOrNonAC;
	}

	public String getSmokingOrNonSmoking() {
		return smokingOrNonSmoking;
	}

	public void setSmokingOrNonSmoking(String smokingOrNonSmoking) {
		this.smokingOrNonSmoking = smokingOrNonSmoking;
	}

	public String getWifiTvGeyser() {
		return wifiTvGeyser;
	}

	public void setWifiTvGeyser(String wifiTvGeyser) {
		this.wifiTvGeyser = wifiTvGeyser;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEditOrDelete() {
		return editOrDelete;
	}

	public void setEditOrDelete(String editOrDelete) {
		this.editOrDelete = editOrDelete;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public String getAmenties() {
		return amenties;
	}

	public void setAmenties(String amenties) {
		this.amenties = amenties;
	}

	public int getTotalRoomAvailable() {
		return totalRoomAvailable;
	}

	public void setTotalRoomAvailable(int totalRoomAvailable) {
		this.totalRoomAvailable = totalRoomAvailable;
	}

	public int getTotalRoomBooked() {
		return totalRoomBooked;
	}

	public void setTotalRoomBooked(int totalRoomBooked) {
		this.totalRoomBooked = totalRoomBooked;
	}

}
