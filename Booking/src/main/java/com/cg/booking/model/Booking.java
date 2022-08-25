package com.cg.booking.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Booking {

	@Transient
	public static final String REFERENCE = "booking_reference";
	@Id
	private int bookingId;
	private List<Passenger> passengerList;

	@NotNull(message = "UserId should not be empty")
	private String userId;

	
	@NotNull(message = "BookingAmount should not be empty")
	private String bookingAmount;

	@NotNull(message = "FlightNumber should not be empty")
	private String flightNumber;

	

	public Booking() {
		super();
	}

	public Booking(int bookingId, List<Passenger> passengerList,
			@NotNull(message = "UserId should not be empty") String userId,
			@NotNull(message = "FlightNumber should not be empty") String flightNumber,
			@NotNull(message = "BookingAmount should not be empty") String bookingAmount) {
		super();
		this.bookingId = bookingId;
		this.passengerList = passengerList;
		this.userId = userId;
		this.flightNumber = flightNumber;
		this.bookingAmount = bookingAmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(String bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public static String getReference() {
		return REFERENCE;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", passengerList=" + passengerList + ", userId=" + userId
				+ ", flightNumber=" + flightNumber + ", bookingAmount=" + bookingAmount + "]";
	}


}
