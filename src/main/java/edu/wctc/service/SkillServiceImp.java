package edu.wctc.service;

import edu.wctc.dao.SkillDAO;
import edu.wctc.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillServiceImp implements SkillService {
    @Autowired
    private SkillDAO skillDAO;

    @Override
    @Transactional
    public List<Skill> getSkills(){
        return skillDAO.getSkills();
    }

    @Override
    @Transactional
    public Skill getSkill(int id){return skillDAO.getSkill(id);}

    @Override
    @Transactional
    public void saveSkill(Skill theSkill){
        skillDAO.saveSkill(theSkill);
    }
}
