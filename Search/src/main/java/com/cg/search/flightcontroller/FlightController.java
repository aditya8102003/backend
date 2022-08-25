package com.cg.search.flightcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.search.model.Flight;
import com.cg.search.service.FlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/search")
public class FlightController {
	
	Logger logger = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	FlightService flightService;
	
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlightDetails(@RequestBody Flight flight) {
		logger.info("Adding Flight");
		flightService.saveFlight(flight);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Flight added Successfully", HttpStatus.ACCEPTED);
		logger.info("Flight added successfully");
		return responseEntity;
	}

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		logger.info("Fetching all flights");
		return flightService.getFlightsList();
	}
	
	@GetMapping("/flights/{flightNumber}")
	public ResponseEntity<?> getFlightsByNumber(@PathVariable String flightNumber) {
		logger.info("Getting flight by flight Number");
		ResponseEntity<?> responseEntity = null;
		Flight flights = flightService.getFlightByNumber(flightNumber);
		responseEntity = new ResponseEntity<>(flights, HttpStatus.OK);
		logger.info("Successfull search of flight by number");
		return responseEntity;
	}

	@GetMapping("/flight/{takeoff}/{landing}")
	public ResponseEntity<?> getFlightByTakeoff(@PathVariable String takeoff, @PathVariable String landing) {
		logger.info("Getting flight by takeoff or landing");
		ResponseEntity<?> responseEntity = null;
		List<Flight> flights = flightService.getFlightBySourceAndDestination(takeoff, landing);
		responseEntity = new ResponseEntity<>(flights, HttpStatus.OK);
		logger.info("Successfull search of flight by takeoff or landing");
		return responseEntity;
	}



	@GetMapping("/flight/takeOff/{takeoff}")
	public ResponseEntity<?> getFlightByTakeOff(@PathVariable String takeoff) {
		logger.info("Getting flight by takeoff");
		ResponseEntity<?> responseEntity = null;
		List<Flight> flights = flightService.getFlightBySource(takeoff);
		responseEntity = new ResponseEntity<>(flights, HttpStatus.OK);
		logger.info("Succesfful search of flight by takeoff");
		return responseEntity;
	
	}

	@GetMapping("/flight/landing/{landing}")
	public ResponseEntity<?> getFlightByLanding(@PathVariable String landing) {
		logger.info("Getting flight by landing");
		ResponseEntity<?> responseEntity = null;
		List<Flight> flights = flightService.getFlightByDestination(landing);
		responseEntity = new ResponseEntity<>(flights, HttpStatus.OK);
		logger.info("Succesful search of flight by landing");
		return responseEntity;
		
	}
	

	@DeleteMapping("/flight/delete/{flightNumber}")
	public ResponseEntity<?> deleteFlight(@PathVariable String flightNumber) {
		logger.info("Deleting Flight by flight Number");
		ResponseEntity<Object> responseEntity = null;
		flightService.delete(flightNumber);
		responseEntity = new ResponseEntity<Object>("Flight Deleted successfully", HttpStatus.OK);
		logger.info("Flight deleted Successfully");
		return responseEntity;
	}
	

	@PutMapping("/updateFlight/{flightNumber}")
	public ResponseEntity<?> updateFlightDetails(@RequestBody Flight flight, @PathVariable String flightNumber) {
		ResponseEntity<Object> responseEntity = null;
		logger.info("Updating flight by flight Number");
		flightService.update(flight, flightNumber);
		responseEntity = new ResponseEntity<Object>("Booking updated successfully", HttpStatus.OK);
		logger.info("Updated Succesfully");
		return responseEntity;
	}

}

//@GetMapping("/flight/{takeoff}/{landing}")
//public ResponseEntity<?> getFlightByTakeoffLandingDepartureDate(@PathVariable String takeoff,
//		@PathVariable String landing, @PathVariable String departureDate) {
//	ResponseEntity<?> responseEntity = null;
//	List<Flight> flights = flightService.getFlightBySourceAndDestinationAndDepartureDate(takeoff, landing, departureDate);
//	responseEntity = new ResponseEntity<>(flights, HttpStatus.OK);
//	return responseEntity;
//
//}
