package com.infy.hotelmanagement.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roomtype")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Roomtype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomtypeid")
	private int roomTypeId;

	@Column(name = "roomtype")
	private String roomType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomtype", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Room> room;

	public Roomtype() {
		super();
	}

	public Roomtype(int roomTypeId, String roomType, Set<Room> room) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomType = roomType;
		this.room = room;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
