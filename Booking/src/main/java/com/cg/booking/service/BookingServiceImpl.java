package com.cg.booking.service;

import static com.cg.booking.model.Booking.REFERENCE;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.booking.exceptions.NotFoundException;
import com.cg.booking.model.Booking;
import com.cg.booking.model.Flight;
import com.cg.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	private RestTemplate template;

	@Autowired
	private ReferenceNumberGenerator referenceNumberGenerator;

	public Booking addBooking(Booking booking) throws NotFoundException {
		logger.info("Adding a new Booking");
		String fn = booking.getFlightNumber();
		System.out.println(fn);
		Flight flight = template.getForObject("http://search-service/search/flights/" + fn, Flight.class);
		booking.setBookingAmount(flight.getFlightFare());
		booking.setBookingId(referenceNumberGenerator.getReferenceNumber(REFERENCE));

		if (bookingRepository.existsById(booking.getBookingId()))
            throw new NotFoundException();
        else {
            Booking newBooking = bookingRepository.save(booking);
            logger.info("Added Booking");
            return newBooking;
		}
	}
	

	public String updateBooking(Booking booking, int bookingId ) {
		logger.info("Updating Booking details");

		Optional<Booking> list = bookingRepository.findById(bookingId);
		System.out.println(list);
		if (!list.isPresent())
			throw new NotFoundException("Booking with the id " + bookingId + "not exist");
		bookingRepository.deleteById(bookingId);
		bookingRepository.save(booking);
		logger.info("Updated Successfully");
		return "Booking Updated with: " + booking.getBookingId();

	}

	public String deleteBooking(int bookingid) {

		logger.info("Deleting booking by id");
		if (bookingRepository.existsById(bookingid)) {
			bookingRepository.deleteById(bookingid);
			logger.info("Booking Deleted");
			return "Booking Deleted with booking Id : " + bookingid;
			
		} else {
			throw new NotFoundException("Booking with Id " + bookingid + " not exist");
		}

	}

	public Optional<Booking> getBooking(int bookingId) {

		logger.info("Getting Booking by id");
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if (!booking.isPresent()) {
			throw new NotFoundException("No Booking available with bookingId : " + bookingId);
		}
		logger.info("Successful search of Booking by id");
		return booking;

	}

	public List<Booking> getAllBookings() {

		logger.info("Getting all booking details");
		List<Booking> allBookingList = bookingRepository.findAll();
		if (allBookingList.isEmpty()) {
			throw new NotFoundException("No Booking available");
		}
		return allBookingList;

	}


//	public List<Booking> getBookingsByUserId(String userId) {
//
//		List<Booking> bookingList = bookingRepository.findByUserid(userId);
//		if (bookingList == null || bookingList.isEmpty()) {
//			throw new NotFoundException("No Booking available with userId : " + userId);
//		}
//		return bookingList;
//
//	}

}
