package com.vdab.controllers;

import com.vdab.models.Location;
import com.vdab.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    @Autowired
    LocationService locationService;


    // region getters
    @RequestMapping(value="/getAllLocations",method = RequestMethod.GET)
    public @NotNull Iterable<Location> getAllLocations(){
        return locationService.getAllLocations();
    }
    // endregion

    // region setters
    @RequestMapping(value = "/addLocation",method = RequestMethod.GET)
    public boolean saveLocation(@RequestParam int locationCode, @RequestParam String locationName,
                               @RequestParam String locationCountry, @RequestParam String locationRegion){
        //System.out.println(locationCode + ", " + locationName + ", " + locationCountry  + ", " + locationRegion);


        locationService.addLocation(locationCode,locationName,locationCountry,locationRegion);

        return false;
    }

    // endregion

    // region delete
    @RequestMapping(value = "/deleteLocation",method = RequestMethod.POST)
    public void deleteLocation(@RequestParam int locationCode){
        System.out.println(locationCode + " will be deleted");
        locationService.deleteLocation(locationCode);
    }

    // endregion

}
