package com.vdab.DAO;

import com.vdab.models.Booking;

import java.sql.Timestamp;
import java.util.List;

public interface BookingDAO {
    void saveBooking(Booking booking);
    void saveBooking(int flightID, int seatAmount, String seatCategory, float bookingPrice, boolean payByEndorsement, boolean isPaid);

    List<Booking> getAllBookings();
    List<Booking> findBookingByFlightID(int flightID);
    List<Booking> findBookingBySeatAmount(int seatAmount);
    List<Booking> findBookingBySeatCategory(String seatCategory);

    List<Booking> findBookingsByLocation(int locationCode);
    List<Booking> findBookingsByDate(Timestamp date);
    List<Booking> findBookingsByAirline(String airline);
    List<Booking> findBookingsByUsername(String username);

    void updateBooking(Booking booking);
}
