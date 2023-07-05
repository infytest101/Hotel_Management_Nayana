package com.infy.hotelmanagement.exception;

public class HotelManagementException extends Exception {

	private static final long serialVersionUID = 843680971820629245L;
	private String message;

	public HotelManagementException() {
	}

	public HotelManagementException(String msg) {
		super(msg);
		this.message = msg;
	}
}
