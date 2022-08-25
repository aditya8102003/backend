package com.cg.search.service;

import java.util.List;

import com.cg.search.model.Flight;

public interface FlightService   {

	Flight saveFlight(Flight flight);

	List<Flight> getFlightsList();

	Flight getFlightByNumber(String flightNumber);

	List<Flight> getFlightBySourceAndDestination(String takeoff, String landing);

//	List<Flight> getFlightBySourceAndDestinationAndDepartureDate(String takeoff, String landing, String departureDate);

	List<Flight> getFlightBySource(String takeoff);

	List<Flight> getFlightByDestination(String landing);

	void delete(String flightNumber);

	Object update(Flight flight, String flightNumber);

	



}