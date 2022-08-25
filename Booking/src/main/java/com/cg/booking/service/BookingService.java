package com.cg.booking.service;

import java.util.List;
import java.util.Optional;

import com.cg.booking.model.Booking;

public interface BookingService {
	
	public Booking addBooking(Booking booking);
	
	public String updateBooking(Booking booking, int bookingId);
	
	public String deleteBooking(int bookingId);
	
	public Optional<Booking> getBooking(int bookingId);
	
	public List<Booking> getAllBookings();
	
//	public List<Booking> getBookingsByUserId(String userId);

}
