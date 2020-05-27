package edu.wctc.service;

import edu.wctc.entity.ClassOb;

import java.util.List;


public interface ClassService {
    List<ClassOb> getClasses();

    ClassOb getClass(int id);

    public void saveClass(ClassOb theClass);
}
