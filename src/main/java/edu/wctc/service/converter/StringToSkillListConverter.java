package edu.wctc.service.converter;

import edu.wctc.entity.Skill;
import edu.wctc.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringToSkillListConverter implements Converter<String, List<Skill>> {
    @Autowired
    private SkillService skillService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public List<Skill> convert(String source) {
        List<String> inputs = new ArrayList<String>();
        List<Skill> skillList = new ArrayList<Skill>();

        inputs = Arrays.asList(source.split(", "));

        for (String input:inputs) {
        int skillId = Integer.parseInt(input);
        Skill aSkill = skillService.getSkill(skillId);
        skillList.add(aSkill);
        }
        return skillList;
    }
}
