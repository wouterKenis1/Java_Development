package com.vdab.services;

import com.vdab.DAO.BookingDAO;
import com.vdab.DAO.FlightDAO;
import com.vdab.models.Booking;
import com.vdab.models.Flight;
import com.vdab.models.PricingInfo;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;
    @Autowired
    FlightDAO flightDAO;

    @Override
    public Iterable<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public Iterable<Booking> findBookingsByFlightID(int flightID) {
        return bookingDAO.findBookingByFlightID(flightID);
    }

    @Override
    public Iterable<Booking> findBookingsBySeatAmount(int seatAmount) {
        return bookingDAO.findBookingBySeatAmount(seatAmount);
    }

    @Override
    public Iterable<Booking> findBookingsBySeatCategory(String seatCategory) {
        return bookingDAO.findBookingBySeatCategory(seatCategory);
    }

    @Override
    public Iterable<Booking> findBookingsByLocation(int locationCode) {
        return bookingDAO.findBookingsByLocation(locationCode);
    }

    @Override
    public Iterable<Booking> findBookingsByDate(Timestamp date) {
        return null;
    }

    @Override
    public Iterable<Booking> findBookingsByAirline(String airline) {
        return null;
    }

    @Override
    public Pair<Float, Float> calculatePrice(int flightID, String type, int amount) {
        System.out.println(type);
        Flight flight = flightDAO.getFlightByID(flightID);
        PricingInfo pricing  = flight.getPricingInfo();
        float basePrice = pricing.getBasePrices().get(type);
        float margins = pricing.getMargins(basePrice);
        float discounts = pricing.getBestPromotion(amount);

        return new Pair<>(basePrice - (discounts/100),margins);
    }

    @Override
    public void saveBooking(Booking booking) {
        bookingDAO.saveBooking(booking);
    }

    @Override
    public boolean createBooking(int flightID, int seatAmount, String seatCategory, float bookingPrice, boolean payByEndorsement, boolean isPaid) {
        Flight flight = flightDAO.getFlightByID(flightID);
        int availableSeats = flight.getSeatingInfo().get(seatCategory);
        if(availableSeats < seatAmount || seatAmount < 0){
            return false;
        }
        bookingDAO.saveBooking(flightID,seatAmount,seatCategory,bookingPrice,payByEndorsement,isPaid);
        return true;
    }


}
