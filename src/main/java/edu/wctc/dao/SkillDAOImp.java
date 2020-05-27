package edu.wctc.dao;

import edu.wctc.entity.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDAOImp implements SkillDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Skill> getSkills(){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //get list via query
        List<Skill> skillList = session.createQuery("from Skill", Skill.class).getResultList();
        //return results
        return skillList;
    }

    @Override
    public void saveSkill(Skill theSkill){
        //current session
        Session session = sessionFactory.getCurrentSession();
        //save what was given
        session.saveOrUpdate(theSkill);
    }

    @Override
    public Skill getSkill(int theID){
        //get current session
        Session session = sessionFactory.getCurrentSession();
        //give the item asked for
        return session.get(Skill.class, theID);
    }
}
