package com.vdab.DAO;

import com.vdab.models.Flight;

import java.sql.Timestamp;
import java.util.List;

public interface FlightDAO {

    List<Flight> getAllFlights();
    Flight getFlightByID(int id);
    List<Flight> findFlightsByLocation(int locationCode);
    List<Flight> findFlightsByDate(Timestamp departureDate);
    List<Flight> findFlightsByAirline(String airline);

    void saveFlight(Flight flight);
    void updateFlight(Flight flight);
    void reserveSeats(int flightID, String seatCategory, int seatAmount);

    void clearTables();
}
