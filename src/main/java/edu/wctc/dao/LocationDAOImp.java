package edu.wctc.dao;

import edu.wctc.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAOImp implements LocationDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Location> getLocations(){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //get list via query
        List<Location> locationList = session.createQuery("from Location", Location.class).getResultList();
        //return results
        return locationList;
    }

    @Override
    public void saveLocation(Location theLocation){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //save what was given
        session.saveOrUpdate(theLocation);
    }

    @Override
    public Location getLocation(int theID){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //give the item asked for
        return session.get(Location.class, theID);
    }
}
