package com.vdab.services;

import com.vdab.models.Location;

import java.util.List;

public interface LocationService {
    Iterable<Location> getAllLocations();
    void addLocation(Location location);
}
