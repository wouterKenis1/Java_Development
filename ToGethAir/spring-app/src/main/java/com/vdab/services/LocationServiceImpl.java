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


}
