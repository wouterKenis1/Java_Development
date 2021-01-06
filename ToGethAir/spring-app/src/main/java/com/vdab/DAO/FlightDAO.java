package com.vdab.DAO;

import com.vdab.models.Flight;

import java.sql.Timestamp;
import java.util.List;

public interface FlightDAO {

    List<Flight> getAllFlights();
    List<Flight> findFlightsByLocation(int locationCode);
    List<Flight> findFlightsByDate(Timestamp departureDate);
    List<Flight> findFlightsByAirline(String airline);

    void saveFlight(Flight flight);
}
