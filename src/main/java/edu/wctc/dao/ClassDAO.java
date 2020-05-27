package edu.wctc.dao;

import edu.wctc.entity.ClassOb;
import java.util.List;

public interface ClassDAO {
    List<ClassOb> getClasses();

    ClassOb getClass(int id);

    public void saveClass(ClassOb theClass);
}
