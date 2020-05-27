package edu.wctc.service;

import edu.wctc.dao.LocationDAO;
import edu.wctc.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {
    @Autowired
    private LocationDAO locationDAO;

    @Override
    @Transactional
    public List<Location> getLocations(){
        return locationDAO.getLocations();
    }

    @Override
    @Transactional
    public Location getLocation(int id){return locationDAO.getLocation(id);}

    @Override
    @Transactional
    public void saveLocation(Location theLocation){
        locationDAO.saveLocation(theLocation);
    }
}
