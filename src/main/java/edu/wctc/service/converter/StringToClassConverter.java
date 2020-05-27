package edu.wctc.service.converter;

import edu.wctc.entity.ClassOb;
import edu.wctc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToClassConverter implements Converter<String, ClassOb> {
    @Autowired
    private ClassService classService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public ClassOb convert(String source) {
        int classId = Integer.parseInt(source);
        ClassOb aClass = classService.getClass(classId);

        return aClass;
    }
}
