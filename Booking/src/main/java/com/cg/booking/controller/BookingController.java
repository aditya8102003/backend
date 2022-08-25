package com.cg.booking.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.booking.model.Booking;
import com.cg.booking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "Flight Booking Controller", tags = "Flight Booking Controller")
@RequestMapping("/booking")
@RestController
public class BookingController {

	Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingService bookingService;

	@ApiOperation(value = "Get all booking details", response = List.class, tags = "Flight Booking Controller", httpMethod = "GET")
	@GetMapping("/allBookings")
	public List<Booking> getAllBookings() {
		logger.info("Getting all Booking Details");
		List<Booking> bookings = bookingService.getAllBookings();
		return bookings;
	}

	@ApiOperation(value = "Get booking details by booking id", response = Booking.class, tags = "Flight Booking Controller", httpMethod = "GET")
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<?> getBooking(@PathVariable int bookingId) {
		logger.info("Getting Booking Details By booking Id");
		ResponseEntity<?> responseEntity = null;
		Optional<Booking> booking = bookingService.getBooking(bookingId);
		responseEntity = new ResponseEntity<>(booking, HttpStatus.OK);
		logger.info("Successfull search of Booking details by Id");
		return responseEntity;
	}

	@ApiOperation(value = "creates a new booking", response = Booking.class, tags = "Flight Booking Controller", httpMethod = "POST")
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		logger.info("Creating a New Booking");
		Booking newBooking = bookingService.addBooking(booking);
		ResponseEntity<Booking> responseEntity = new ResponseEntity<Booking>(newBooking, HttpStatus.ACCEPTED);
		logger.info("Created a new Booking");
		return responseEntity;
	}

	@ApiOperation(value = "updates existing booking details based on booking ID", response = Booking.class, tags = "Flight Booking Controller", httpMethod = "PUT")
	@PutMapping("/updateBooking/{bookingId}")
	public ResponseEntity<Object> updateBooking(@RequestBody Booking booking, @PathVariable int bookingId) {
		logger.info("Updating booking details by id");
		ResponseEntity<Object> responseEntity = null;
		bookingService.updateBooking(booking, bookingId);
		responseEntity = new ResponseEntity<Object>("Booking Updated successfully", HttpStatus.OK);
		logger.info(" Booking Updated Successfully");
		return responseEntity;
	}

	@ApiOperation(value = "deletes booking details based on booking ID", response = Booking.class, tags = "Flight Booking Controller", httpMethod = "DELETE")
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<Object> deleteBooking(@PathVariable int bookingId) {
		logger.info("Deleting booking details by Id");
		ResponseEntity<Object> responseEntity = null;
		bookingService.deleteBooking(bookingId);
		logger.info("Deleted Successfully");
		responseEntity = new ResponseEntity<Object>("Booking Deleted successfully", HttpStatus.OK);
		return responseEntity;

	}
}
