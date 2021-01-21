package com.vdab.services;

import com.vdab.models.Booking;
import com.vdab.models.Flight;
import com.vdab.models.Location;
import javafx.util.Pair;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

public interface BookingService {
    Iterable<Booking> getAllBookings();
    Iterable<Booking> findBookingsByFlightID(int flightID);
    Iterable<Booking> findBookingsBySeatAmount(int seatAmount);
    Iterable<Booking> findBookingsBySeatCategory(String seatCategory);

    Iterable<Booking> findBookingsByLocation(int locationCode);
    Iterable<Booking> findBookingsByDate(Timestamp date);
    Iterable<Booking> findBookingsByAirline(String airline);
    Iterable<Booking> findBookingsByUsername(String username);

    Pair<Float,Float> calculatePrice(int flightID,String type, int amount);

    boolean saveBooking(Booking booking);
    boolean createBooking(int flightID,int seatAmount,String seatCategory,float bookingPrice,
                          boolean payByEndorsement,boolean isPaid, String username);

    int getBookingsAmount();
    int getAverageBookingPrice();
    int getMinBookingPrice();
    int getMaxBookingPrice();
}
