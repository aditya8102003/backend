package com.cg.search.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.cg.search.model.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

	List<Flight> findByTakeoffAndLanding(String takeoff, String landing);

	List<Flight> findByTakeoffAndLandingAndDepartureDate(String takeoff, String landing, String departureDate);

	List<Flight> findByTakeoff(String takeoff);

	List<Flight> findByLanding(String landing);

	

}
