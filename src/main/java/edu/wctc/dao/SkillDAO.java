package edu.wctc.dao;

import edu.wctc.entity.Skill;

import java.util.List;

public interface SkillDAO {
    List<Skill> getSkills();

    Skill getSkill(int id);

    public void saveSkill(Skill theSkill);
}
