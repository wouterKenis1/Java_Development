package com.vdab.controllers;

import com.vdab.models.Flight;
import com.vdab.models.PricingInfo;
import com.vdab.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

    @Autowired
    FlightService flightService;


    // region getters
    @RequestMapping(value="/getAllFlights",method = RequestMethod.GET)
    public @NotNull Iterable<Flight> getAllFlights(){
        Iterable<Flight> flights = flightService.getAllFlights();
        return flights;
    }
    // endregion

// airline, duration, departuretime, departurelocationcode, arrivallocationcode, flightid


    // region setters
    @RequestMapping(value = "/saveFlight",method = RequestMethod.POST)
    public void saveFlight(@RequestBody Flight flight){
        System.out.println(flight);
        flightService.saveFlight(flight);

    }


}
