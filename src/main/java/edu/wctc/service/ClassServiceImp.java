package edu.wctc.service;

import edu.wctc.dao.ClassDAO;
import edu.wctc.entity.ClassOb;
import edu.wctc.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImp implements ClassService {
    @Autowired
    private ClassDAO classDAO;

    @Override
    @Transactional
    public List<ClassOb> getClasses(){
        return classDAO.getClasses();
    }

    @Override
    @Transactional
    public ClassOb getClass(int id){return classDAO.getClass(id);}

    @Override
    @Transactional
    public void saveClass(ClassOb theClass){
        classDAO.saveClass(theClass);
    }
}
