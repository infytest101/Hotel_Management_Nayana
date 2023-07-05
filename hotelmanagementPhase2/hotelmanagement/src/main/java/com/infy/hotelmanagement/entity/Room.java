package com.infy.hotelmanagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomid")
	private int roomId;

	@Nonnull
	@Column(name = "roomtypeid", insertable = false, updatable = false)
	private int roomTypeId;

	@Nonnull
	@Column(name = "amenitiesid", insertable = false, updatable = false)
	private int amenitiesId;

	@Nonnull
	@Column(name = "roomname")
	private String roomName;

	@Nonnull
	@Column(name = "totalroomsavailable")
	private int totalRoomsAvailable;

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
	@Column(name = "price")
	private int price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roomtypeid")
	private Roomtype roomtype;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "amenitiesid")
	private Amenities amenities;

	public Room() {
		super();
	}

	public Room(int roomId, int roomTypeId, int amenitiesId, String roomName, int totalRoomsAvailable,
			LocalDateTime createDate, String createBy, LocalDateTime updateDate, String updatedBy, int price,
			Roomtype roomtype, Amenities amenities) {
		super();
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.amenitiesId = amenitiesId;
		this.roomName = roomName;
		this.totalRoomsAvailable = totalRoomsAvailable;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updatedBy = updatedBy;
		this.price = price;
		this.roomtype = roomtype;
		this.amenities = amenities;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public int getAmenitiesId() {
		return amenitiesId;
	}

	public void setAmenitiesId(int amenitiesId) {
		this.amenitiesId = amenitiesId;
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime localDateTime) {
		this.createDate = localDateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public Amenities getAmenities() {
		return amenities;
	}

	public void setAmenities(Amenities amenities) {
		this.amenities = amenities;
	}

}
