package com.vdab;

import com.vdab.models.Booking;
import com.vdab.services.BookingService;
import com.vdab.services.FlightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class WouterApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WouterApplication.class, args);

//		LocationService service = ctx.getBean(LocationService.class);
//
//		Location location = new Location();
//		location.setName("testName");
//		location.setCountry("Belgium");
//		location.setRegion("Europe");
//		location.setCode(1234);
//
//		service.addLocation(location);

		FlightService flightService = ctx.getBean(FlightService.class);
		BookingService bookingService = ctx.getBean(BookingService.class);

//		flightService.clearTables();

//		Flight flight = new Flight();
//		flight.setId(1);
//		flight.setArrivalLocationCode(1234);
//		flight.setDepartureLocationCode(1234);
//		flight.setDuration(10.0f);
//		flight.setAirline("NowhAir");
//		{
//			PricingInfo pricingInfo = new PricingInfo();
//			pricingInfo.setFlightID(1);
//			{
//				Vector<Pair<Integer, Float>> promotions = new Vector<Pair<Integer, Float>>();
//				promotions.add(new Pair<>(3, 1.5f));
//				pricingInfo.setPromotions(promotions);
//			}
//			{
//				Map<String,Float> basePrices = new HashMap<>();
//				basePrices.put("buissness", 200.0f);
//				pricingInfo.setBasePrices(basePrices);
//			}
//			flight.setPricingInfo(pricingInfo);
//		}
//		{
//			Map<String,Integer> availableSeats = new HashMap<>();
//			availableSeats.put("buissness", 20);
//			flight.setSeatingInfo(availableSeats);
//		}
//		{
//			Timestamp time = new Timestamp(System.currentTimeMillis());
//			flight.setDepartureTime(time);
//		}
//		flightService.saveFlight(flight);

//
//		Booking booking = new Booking();
//		booking.setBookingID(1);
//		booking.setFlight(1);
//		booking.setSeatAmount(2);
//		booking.setSeatCategory("Buissness");
//		booking.setBookingPrice(1.5f);
//		booking.setPaid(false);
//		bookingService.saveBooking(booking);
//
//		List<Booking> bookings = (List<Booking>) bookingService.findBookingsByLocation(1234);
//		System.out.println(bookings);


	}

}
