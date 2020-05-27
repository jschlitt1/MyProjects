package edu.wctc.service;

import edu.wctc.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getSkills();

    Skill getSkill(int id);

    public void saveSkill(Skill theSkill);
}