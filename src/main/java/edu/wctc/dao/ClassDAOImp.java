package edu.wctc.dao;

import edu.wctc.entity.ClassOb;
import edu.wctc.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDAOImp implements ClassDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ClassOb> getClasses(){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //get list from query
        List<ClassOb> classList = session.createQuery("from ClassOb", ClassOb.class).getResultList();
        //return results
        return classList;
    }

    @Override
    public ClassOb getClass(int id){
        //get session
        Session session = sessionFactory.getCurrentSession();
        //get via primary key
        ClassOb aClass = session.get(ClassOb.class, id);
        //return result
        return aClass;
    }

    @Override
    public void saveClass(ClassOb theClass){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //save what was given
        session.saveOrUpdate(theClass);
    }
}
