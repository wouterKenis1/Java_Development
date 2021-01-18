package com.vdab.services;

import com.vdab.models.Location;

import java.util.List;

public interface LocationService {
    Iterable<Location> getAllLocations();
    void addLocation(Location location);
    void addLocation(int code, String name, String country, String region);

    void deleteLocation(int locationCode);
}
