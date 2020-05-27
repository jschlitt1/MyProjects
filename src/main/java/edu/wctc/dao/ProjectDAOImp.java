package edu.wctc.dao;

import edu.wctc.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImp implements ProjectDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Project> getProjects(){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //get list via query
        List<Project> projectList = session.createQuery("from Project", Project.class).getResultList();
        //return results
        return projectList;
    }

    @Override
    public void saveProject(Project theProject){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //save what was given
        session.saveOrUpdate(theProject);
    }

    @Override
    public Project getProject(int theID){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //give the item asked for
        return session.get(Project.class, theID);
    }

    @Override
    public void deleteProject(int theID){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //select item to get a persistent copy
        Project doomedProject = session.get(Project.class, theID);

        //check to see if item was real, delete if it was
        if(doomedProject != null){
            session.delete(doomedProject);
        }
    }

    @Override
    public List<Project> getProjectByName(String search){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //make it lowercase
        search = "%" + search.toLowerCase() + "%";

        Query<Project> query = session.createQuery("from Project where lower(name) like :nameToSearch");
        query.setParameter("nameToSearch", search);

        return query.getResultList();
    }
}
