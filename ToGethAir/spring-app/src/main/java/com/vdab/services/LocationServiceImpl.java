package com.vdab.services;

import com.vdab.DAO.LocationDAO;
import com.vdab.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDAO locationDAO;

    @Override
    public Iterable<Location> getAllLocations() {
        return locationDAO.getAllLocations();
    }

    @Override
    public void addLocation(Location location) {
        locationDAO.addLocation(location);
    }

    @Override
    public void addLocation(int code, String name, String country, String region) {
        Location location = new Location();
        location.setCode(code);
        location.setName(name);
        location.setCountry(country);
        location.setRegion(region);
        locationDAO.addLocation(location);
    }

    @Override
    public void deleteLocation(int locationCode) {
        locationDAO.deleteLocation(locationCode);
    }


}
