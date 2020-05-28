package edu.wctc.service.converter;

import edu.wctc.entity.Skill;
import edu.wctc.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToSkillConverter implements Converter<String, Skill> {
    @Autowired
    private SkillService skillService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public Skill convert(String source) {
        int skillId = Integer.parseInt(source);
        Skill aSkill = skillService.getSkill(skillId);

        return aSkill;
    }
}
