package com.infy.hotelmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookingdetails")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingdetailsid")
	private long bookingDetailsId;

	@Nonnull
	@Column(name = "createdate")
	private LocalDateTime createDate;

	@Nonnull
	@Column(name = "createby")
	private String createBy;

	@Column(name = "updatedate")
	private LocalDateTime updateDate;

	@Column(name = "updatedby")
	private String updatedBy;

	@Nonnull
	@Column(name = "totalroomsbooked")
	private int totalRoomsBooked;

	@Nonnull
	@Column(name = "bookingdatestart")
	private LocalDate bookingDateStart;

	@Nonnull
	@Column(name = "bookingdateend")
	private LocalDate bookingDateEnd;

	@Nonnull
	@Column(name = "roomid")
	private int roomId;

	@Nonnull
	@Column(name = "customerid")
	private int customerId;

	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDetails(long bookingDetailsId, LocalDateTime createDate, String createBy, LocalDateTime updateDate,
			String updatedBy, int totalRoomsBooked, LocalDate bookingDateStart, LocalDate bookingDateEnd, int roomId,
			int customerId) {
		super();
		this.bookingDetailsId = bookingDetailsId;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updatedBy = updatedBy;
		this.totalRoomsBooked = totalRoomsBooked;
		this.bookingDateStart = bookingDateStart;
		this.bookingDateEnd = bookingDateEnd;
		this.roomId = roomId;
		this.customerId = customerId;

	}

	public long getBookingDetailsId() {
		return bookingDetailsId;
	}

	public void setBookingDetailsId(long bookingDetailsId) {
		this.bookingDetailsId = bookingDetailsId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String string) {
		this.createBy = string;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getTotalRoomsBooked() {
		return totalRoomsBooked;
	}

	public void setTotalRoomsBooked(int totalRoomsBooked) {
		this.totalRoomsBooked = totalRoomsBooked;
	}

	public LocalDate getBookingDateStart() {
		return bookingDateStart;
	}

	public void setBookingDateStart(LocalDate bookingDateStart) {
		this.bookingDateStart = bookingDateStart;
	}

	public LocalDate getBookingDateEnd() {
		return bookingDateEnd;
	}

	public void setBookingDateEnd(LocalDate bookingDateEnd) {
		this.bookingDateEnd = bookingDateEnd;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int i) {
		this.customerId = i;
	}

}
