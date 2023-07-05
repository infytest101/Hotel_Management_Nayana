package com.infy.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Amenities")
@JsonIgnoreProperties
public class Amenities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amenitiesid")
	private int amenitiesId;

	@Nonnull
	@Column(name = "isacavailable")
	private int isACAvailable;

	@Nonnull
	@Column(name = "issmokingavailable")
	private int isSmokingAvailable;

	@Nonnull
	@Column(name = "iswifiavailable")
	private int isWifiAvailable;

	@Nonnull
	@Column(name = "istvavailable")
	private int isTVAvailable;

	@Nonnull
	@Column(name = "isgeyseravailable")
	private int isGeyserAvailable;

	public Amenities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amenities(int amenitiesId, int isACAvailable, int isSmokingAvailable, int isWifiAvailable, int isTVAvailable,
			int isGeyserAvailable) {
		super();
		this.amenitiesId = amenitiesId;
		this.isACAvailable = isACAvailable;
		this.isSmokingAvailable = isSmokingAvailable;
		this.isWifiAvailable = isWifiAvailable;
		this.isTVAvailable = isTVAvailable;
		this.isGeyserAvailable = isGeyserAvailable;
	}

	public int getAmenitiesId() {
		return amenitiesId;
	}

	public void setAmenitiesId(int amenitiesId) {
		this.amenitiesId = amenitiesId;
	}

	public int getIsACAvailable() {
		return isACAvailable;
	}

	public void setIsACAvailable(int isACAvailable) {
		this.isACAvailable = isACAvailable;
	}

	public int getIsSmokingAvailable() {
		return isSmokingAvailable;
	}

	public void setIsSmokingAvailable(int isSmokingAvailable) {
		this.isSmokingAvailable = isSmokingAvailable;
	}

	public int getIsWifiAvailable() {
		return isWifiAvailable;
	}

	public void setIsWifiAvailable(int isWifiAvailable) {
		this.isWifiAvailable = isWifiAvailable;
	}

	public int getIsTVAvailable() {
		return isTVAvailable;
	}

	public void setIsTVAvailable(int isTVAvailable) {
		this.isTVAvailable = isTVAvailable;
	}

	public int getIsGeyserAvailable() {
		return isGeyserAvailable;
	}

	public void setIsGeyserAvailable(int isGeyserAvailable) {
		this.isGeyserAvailable = isGeyserAvailable;
	}

}
