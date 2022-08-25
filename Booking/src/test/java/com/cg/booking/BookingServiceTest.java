package com.cg.booking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.cg.booking.model.Booking;
import com.cg.booking.repository.BookingRepository;
import com.cg.booking.service.BookingServiceImpl;
import com.cg.booking.service.ReferenceNumberGenerator;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

	@InjectMocks
	BookingServiceImpl bookingServiceImpl;

	@Mock
	BookingRepository bookingRepository;

	@Mock
	private RestTemplate template;

	@Mock
	private ReferenceNumberGenerator referenceNumberGenerator;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	public List<Booking> getBookingDetails() {

		List<Booking> list = new ArrayList<>();
		list.add(new Booking(123, new ArrayList<>(), "1234", "Test1234", "2000"));
		list.add(new Booking(124, new ArrayList<>(), "1235", "Test1235", "4000"));

		return list;
	}

	public Optional<Booking> getBookingOptional() {

		Booking booking = new Booking(123, new ArrayList<>(), "1234", "Test1234", "2000");
		Optional<Booking> optional = Optional.of(booking);
		return optional;

	}

	public Booking getBooking() {

		return new Booking(123, new ArrayList<>(), "1234", "Test1234", "2000");
	}

	@Test
	public void testupdateBooking() {

		when(bookingRepository.findById(2)).thenReturn(getBookingOptional());
		doNothing().when(bookingRepository).deleteById(2);
		when(bookingRepository.save(Mockito.any())).thenReturn(getBooking());

		String result = bookingServiceImpl.updateBooking(getBooking(), 2);
		System.out.println(result);
		assertNotNull(result);
		assertEquals("Booking Updated with: 123", result);

	}

	@Test
	public void testDeleteBooking() {

		when(bookingRepository.existsById(2)).thenReturn(true);
		doNothing().when(bookingRepository).deleteById(2);

		String result = bookingServiceImpl.deleteBooking(2);
		System.out.println(result);
		assertNotNull(result);
		assertEquals("Booking Deleted with booking Id : 2", result);
	}

	@Test
	public void testGetBooking() {

		when(bookingRepository.findById(2)).thenReturn(getBookingOptional());
		Optional<Booking> result = bookingServiceImpl.getBooking(2);
		assertNotNull(result);
	}

	@Test
	public void testGetAllBooking() {

		when(bookingRepository.findAll()).thenReturn(getBookingDetails());
		List<Booking> result = bookingServiceImpl.getAllBookings();
		assertFalse(result.isEmpty());
		assertEquals(2, result.size());
	}

}
