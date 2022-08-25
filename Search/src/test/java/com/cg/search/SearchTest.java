package com.cg.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.search.exception.NotFoundException;
import com.cg.search.model.Flight;
import com.cg.search.repository.FlightRepository;
import com.cg.search.service.FlightService;

@SpringBootTest
public class SearchTest {

	private static final int id = 0;
	@Autowired
	private FlightService flightService;
	@MockBean
	private FlightRepository flightRepository;

	@Test
	@DisplayName("Get All Flight Test")
	public void getallFlightTest() {
		when(flightRepository.findAll()).thenReturn((List<Flight>) Stream.of(
				new Flight("W100", "airAsia", "pune", "mumbai", false, "2hr", "Sun Aug 07 00:49:34 IST 2022",
						"Sun Aug 07 00:49:34 IST 2022", "4am", "2am", 8000, 1),
				new Flight("X100", "airAsia", "pune", "mumbai", false, "2hr", "Sun Aug 07 00:49:34 IST 2022",
						"Sun Aug 07 00:49:34 IST 2022", "4am", "2am", 8000, 1))
				.collect(Collectors.toList()));
		assertEquals(2, flightService.getFlightsList().size());
	}

	@Test
	@DisplayName("Adding Flight Test")
	public void addFlightTest() throws NotFoundException {
		Flight flight = new Flight("W100", "airAsia", "pune", "mumbai", false, "2hr", "Sun Aug 07 00:49:34 IST 2022",
				"Sun Aug 07 00:49:34 IST 2022", "4am", "2am", 8000, 1);
		int id = 0;
		flightService.saveFlight(flight);
	}

	@Test
	void testDeleteFlight() throws NotFoundException {
		Mockito.when(flightRepository.existsById(Mockito.anyString())).thenReturn(true);

	}

	@Test
	@DisplayName("Update Test")
	public void updateFlightTest() {
		Flight flight = new Flight("X100", "airAsia", "pune", "mumbai", false, "2hr", "Sun Aug 07 00:49:34 IST 2022",
				"Sun Aug 07 00:49:34 IST 2022", "4am", "2am", 8000, 1);
		int id = 0;
		flightService.saveFlight(flight);
	}
}