package com.cg.checkin.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.checkin.model.CheckInRecord;
import com.cg.checkin.repository.CheckInRepo;
import com.cg.checkin.service.CheckInIdGenerator;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/checkin")
public class CheckInController {
	
	Logger logger = LoggerFactory.getLogger(CheckInController.class);


	@Autowired
	private CheckInRepo checkInRepo;

	@Autowired
	private CheckInIdGenerator checkInIdGenerator;

	@ApiOperation(value = "Get CheckIn details", response = List.class, tags = "Check In Controller", httpMethod = "GET")
	@GetMapping("/fetchAllCHeckIn")
	public ResponseEntity<?> getFlights() {
		
		logger.info("Getting all CheckIn Details");
		return ResponseEntity.ok(this.checkInRepo.findAll());
	}

	@ApiOperation(value = "Get Check In details", response = CheckInRecord.class, tags = "Check In Controller", httpMethod = "GET")
	@GetMapping("/{id}")
	public Optional<CheckInRecord> getCheckIn(@PathVariable long id) {
		logger.info("Getting checkIn Details By Id");
		return checkInRepo.findById(id);
	}

	@ApiOperation(value = "create check In details", response = CheckInRecord.class, tags = "Check In Controller", httpMethod = "POST")
	@PostMapping("/create")
	public ResponseEntity<?> checkIn(@RequestBody CheckInRecord checkIn) {

		logger.info("Creating a new CheckIn Details");
		checkIn.setCheckinId(checkInIdGenerator.getCheckInId(CheckInRecord.SEQUENCE_NAME));
		CheckInRecord save = this.checkInRepo.save(checkIn);
		return ResponseEntity.ok(save);

	}

	@ApiOperation(value = "Update check in details", response = CheckInRecord.class, tags = "Check In Controller", httpMethod = "PUT")
	@PutMapping("/updatecheckin")
	public ResponseEntity<?> updateCheckInRecord(@RequestBody CheckInRecord updateCheckInRecord) {

		logger.info("Updating CheckIn Details");
		CheckInRecord update = this.checkInRepo.save(updateCheckInRecord);
		return ResponseEntity.ok(update);
	}

}
