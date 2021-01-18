package com.vdab.controllers;


import com.vdab.DAO.BookingDAO;
import com.vdab.helper.BookingData;
import com.vdab.models.Booking;
import com.vdab.models.Flight;
import com.vdab.models.Location;
import com.vdab.services.BookingService;
import com.vdab.services.FlightService;
import com.vdab.services.LocationService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    LocationService locationService;
    @Autowired
    FlightService flightService;
    @Autowired
    BookingService bookingService;

    //region List Data Locally
    @RequestMapping(value="/listLocations", method= RequestMethod.GET)
    public ModelAndView listLocations(ModelMap model){
        model.addAttribute("locations",locationService.getAllLocations());
        return new ModelAndView("listLocations", model);
    }

    @RequestMapping(value="/listFlights", method= RequestMethod.GET)
    public ModelAndView listFlights(ModelMap model){
        model.addAttribute("flights",flightService.getAllFlights());
        return new ModelAndView("listFlights", model);
    }

    //endregion





}
