package com.cg.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.booking.model.Booking;

public interface BookingRepository  extends MongoRepository<Booking, Integer>  {

//	List<Booking> findByUserid(String userId);
	
	Booking findByBookingid(int bookingId);
	
}
