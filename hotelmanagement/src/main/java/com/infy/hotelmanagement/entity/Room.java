package com.infy.hotelmanagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomid")
	private int roomId;

	@Column(insertable = false, updatable = false)
	private int roomtypeid;

	@Column(name = "isacavailable")
	private String isACAvailable;

	@Column(name = "issmokingavailable")
	private String isSmokingAvailable;

	@Column(name = "amenties")
	private Object amenties;

	@Column(name = "price")
	private int price;
	
	@Column(name = "totalroomavailable")
	private int totalRoomAvailable;
	
	@Column(name = "totalroombooked")
	private int totalRoomBooked;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomtypeid")
	private Roomtype roomtype;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingDetails> bookingDetails;

	public Room() {
		super();
	}

	public Room(int roomId, int roomtypeid, String isACAvailable, String isSmokingAvailable, String amenties, int price,
			int totalRoomAvailable, int totalRoomBooked, Roomtype roomtype, List<BookingDetails> bookingDetails) {
		super();
		this.roomId = roomId;
		this.roomtypeid = roomtypeid;
		this.isACAvailable = isACAvailable;
		this.isSmokingAvailable = isSmokingAvailable;
		this.amenties = amenties;
		this.price = price;
		this.totalRoomAvailable = totalRoomAvailable;
		this.totalRoomBooked = totalRoomBooked;
		this.roomtype = roomtype;
		this.bookingDetails = bookingDetails;
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

	public String getIsACAvailable() {
		return isACAvailable;
	}

	public void setIsACAvailable(String isACAvailable) {
		this.isACAvailable = isACAvailable;
	}

	public String getIsSmokingAvailable() {
		return isSmokingAvailable;
	}

	public void setIsSmokingAvailable(String isSmokingAvailable) {
		this.isSmokingAvailable = isSmokingAvailable;
	}

	public Object getAmenties() {
		return amenties;
	}

	public void setAmenties(Object amenties) {
		this.amenties = amenties;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

}
