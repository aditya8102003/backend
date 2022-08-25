package com.cg.search.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.search.exception.NotFoundException;
import com.cg.search.model.Flight;
import com.cg.search.repository.FlightRepository;

@Service
public class FlightServiceImplementation implements FlightService {

	Logger logger = LoggerFactory.getLogger(FlightServiceImplementation.class);

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> getFlightsList() {

		logger.info("Getting flight list");
		List<Flight> list = flightRepository.findAll();
		if (list.isEmpty())
			throw new NotFoundException("No Flights Available");
		logger.info("Successfull searc of all flights");
		return list;
	}

	public Flight getFlightByNumber(@PathVariable String flightNumber) {
		logger.info("Getting flight by flight Number");
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		logger.info("Successfull search of flight by Number");
		return list.get();
	}

	public Flight saveFlight(Flight flight) {
		logger.info("Adding flight");
		Flight flights = flightRepository.insert(flight);
		logger.info("Flight Added Successfully");
		return flights;
	}

	public void delete(@PathVariable String flightNumber) {
		logger.info("Deleting flight by flight Number");
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		logger.info("FLight Deleted Successfully");
		flightRepository.deleteById(flightNumber);
	}

	public Object update(Flight flight, String flightNumber) {
		logger.info("Updating Flight by flightNumber");
		Optional<Flight> list = flightRepository.findById(flightNumber);
		if (!list.isPresent())
			throw new NotFoundException("Flight with the flight number " + flightNumber + "not exist");
		flightRepository.deleteById(flightNumber);
		flightRepository.save(flight);
		logger.info("Flight Updated Successfully");
		return "Flight updated successfully";

	}

	public List<Flight> getFlightBySourceAndDestination(@PathVariable String takeoff, @PathVariable String landing) {
		logger.info("Getting flight by Source and Destination");
		List<Flight> list = flightRepository.findByTakeoffAndLanding(takeoff, landing);
		if (list.isEmpty())
			throw new NotFoundException(
					"Flight with takeoff " + takeoff + "and landing " + landing + " doesnot exist.");
		logger.info("Successful search of flight by source and destination");
		return list;

	}

	public List<Flight> getFlightBySource(@PathVariable String takeoff) {
		logger.info("Getting Flight By source");
		List<Flight> list = flightRepository.findByTakeoff(takeoff);
		if (list.isEmpty())
			throw new NotFoundException("Flight with takeoff" + takeoff + " doesnot exist.");
		logger.info("Successsful search of flight by source");
		return list;
	}

	public List<Flight> getFlightByDestination(@PathVariable String landing) {
		logger.info("Getting flights by destination");
		List<Flight> list = flightRepository.findByLanding(landing);
		if (list.isEmpty())
			throw new NotFoundException("Flight with landing" + landing + " doesnot exist.");
		logger.info("Successful search of flight by Destination");
		return list;
	}

}
