package edu.wctc.dao;

import edu.wctc.entity.Location;

import java.util.List;

public interface LocationDAO {
    List<Location> getLocations();

    Location getLocation(int id);

    public void saveLocation(Location theLocation);
}
