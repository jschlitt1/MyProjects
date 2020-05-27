package edu.wctc.service;

import edu.wctc.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> getLocations();

    Location getLocation(int id);

    public void saveLocation(Location theLocation);
}
