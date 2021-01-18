package com.vdab.services;


import com.vdab.DAO.FlightDAO;
import com.vdab.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightDAO flightDAO;

    @Override
    public Iterable<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    public Flight getFlightByID(int id){
        return flightDAO.getFlightByID(id);
    }

    @Override
    public Iterable<Flight> findFlightsByLocation(int locationCode) {
        return flightDAO.findFlightsByLocation(locationCode);
    }

    @Override
    public Iterable<Flight> findFlightsByDate(Timestamp departureDate) {
        return flightDAO.findFlightsByDate(departureDate);
    }

    @Override
    public Iterable<Flight> findFlightsByAirline(String airline) {
        return flightDAO.findFlightsByAirline(airline);
    }

    @Override
    public void saveFlight(Flight flight) {
        flightDAO.saveFlight(flight);
    }

    @Override
    public void clearTables(){
        flightDAO.clearTables();
    }
}
