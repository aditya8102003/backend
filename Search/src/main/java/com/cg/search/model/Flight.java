package com.cg.search.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Flight {
	@Id
	private String flightNumber;

	@NotNull(message = "Flight Name should not be empty")
	private String flightName;

	@NotNull(message = "TakeOff should not be empty")
	private String takeoff;

	@NotNull(message = "Landing should not be empty")
	private String landing;

	@NotNull(message = "LayOver should not be empty")
	private boolean layover;

	@NotNull(message = "Duration should not be empty")
	private String duration;

	@NotNull(message = "DepartureDate should not be empty")
	private String departureDate;

	@NotNull(message = "ArrivalDate should not be empty")
	private String arrivalDate;

	@NotNull(message = "DepartureTime should not be empty")
	private String departureTime;

	@NotNull(message = "ArrivalTime should not be empty")
	private String arrivalTime;

	@NotNull(message = "FlightFare should not be empty")
	private double flightFare;

	@NotNull(message = "TotalSeats should not be empty")
	private int totalSeats;
	
	public Flight() {
		
	}

	public Flight(String flightNumber, @NotNull(message = "Flight Name should not be empty") String flightName,
			@NotNull(message = "TakeOff should not be empty") String takeoff,
			@NotNull(message = "Landing should not be empty") String landing,
			@NotNull(message = "LayOver should not be empty") boolean layover,
			@NotNull(message = "Duration should not be empty") String duration,
			@NotNull(message = "DepartureDate should not be empty") String departureDate,
			@NotNull(message = "ArrivalDate should not be empty") String arrivalDate,
			@NotNull(message = "DepartureTime should not be empty") String departureTime,
			@NotNull(message = "ArrivalTime should not be empty") String arrivalTime,
			@NotNull(message = "FlightFare should not be empty") double flightFare,
			@NotNull(message = "TotalSeats should not be empty") int totalSeats) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.takeoff = takeoff;
		this.landing = landing;
		this.layover = layover;
		this.duration = duration;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightFare = flightFare;
		this.totalSeats = totalSeats;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getTakeoff() {
		return takeoff;
	}

	public void setTakeoff(String takeoff) {
		this.takeoff = takeoff;
	}

	public String getLanding() {
		return landing;
	}

	public void setLanding(String landing) {
		this.landing = landing;
	}

	public boolean isLayover() {
		return layover;
	}

	public void setLayover(boolean layover) {
		this.layover = layover;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(double flightFare) {
		this.flightFare = flightFare;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightName=" + flightName + ", takeoff=" + takeoff
				+ ", landing=" + landing + ", layover=" + layover + ", duration=" + duration + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", flightFare=" + flightFare + ", totalSeats=" + totalSeats + "]";
	}

	
}
