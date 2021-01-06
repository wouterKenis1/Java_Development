package com.vdab.controllers;


import com.vdab.models.Location;
import com.vdab.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    LocationService locationService;

    //region List locations
    @RequestMapping(value="/listLocations", method= RequestMethod.GET)
    public ModelAndView listLocations(ModelMap model){
        model.addAttribute("locations",locationService.getAllLocations());
        return new ModelAndView("listLocations", model);
    }
    //endregion

    @RequestMapping(value="/getAllLocations",method = RequestMethod.GET)
    public @NotNull Iterable<Location> getAllLocations(){
        return locationService.getAllLocations();
    }
}
