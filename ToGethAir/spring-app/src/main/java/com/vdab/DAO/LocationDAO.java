package com.vdab.DAO;

import com.vdab.models.Location;

import java.util.List;

public interface LocationDAO {

    //region Get/Find
    List<Location> getAllLocations();

    //endregion

    //region Add/Delete
    void addLocation(Location location);

    //endregion
}
