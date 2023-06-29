package com.infy.hotelmanagement.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookingdetails")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingdetailsid")
	private int bookingdetailsid;

	@Column(name = "bookingdatestart")
	private LocalDate bookingdatestart;

	@Column(name = "bookingdateend")
	private LocalDate bookingdateend;

	@Column(name = "customername")
	private String customername;

	@Column(name = "customeremail")
	private String customeremail;

	@Column(name = "customermobile")
	private String customermobile;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;

	public int getBookingdetailsid() {
		return bookingdetailsid;
	}

	public void setBookingdetailsid(int bookingdetailsid) {
		this.bookingdetailsid = bookingdetailsid;
	}

	public LocalDate getBookingdatestart() {
		return bookingdatestart;
	}

	public void setBookingdatestart(LocalDate bookingdatestart) {
		this.bookingdatestart = bookingdatestart;
	}

	public LocalDate getBookingdateend() {
		return bookingdateend;
	}

	public void setBookingdateend(LocalDate bookingdateend) {
		this.bookingdateend = bookingdateend;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getCustomermobile() {
		return customermobile;
	}

	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
