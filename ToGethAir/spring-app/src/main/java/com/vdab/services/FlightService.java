package com.vdab.services;

import com.vdab.models.Flight;

import java.sql.Timestamp;
import java.util.List;

public interface FlightService {

    Iterable<Flight> getAllFlights();
    Flight getFlightByID(int id);
    Iterable<Flight> findFlightsByLocation(int locationCode);
    Iterable<Flight> findFlightsByDate(Timestamp departureDate);
    Iterable<Flight> findFlightsByAirline(String airline);

    void saveFlight(Flight flight);

    void clearTables();
}
