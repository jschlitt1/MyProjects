package edu.wctc.service;

import edu.wctc.dao.ProjectDAO;
import edu.wctc.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    private ProjectDAO projectDAO;

    @Override
    @Transactional
    public void deleteProject(int theID){projectDAO.deleteProject(theID);}

    @Override
    @Transactional
    public Project getProject(int theID){return projectDAO.getProject(theID);}

    @Override
    public Project getProjectAndClass(int ProjectID){
        Project aProject = projectDAO.getProject(ProjectID);
        //touch the first one to make it load the list
        if(!aProject.getDetail().getClasses().isEmpty()){
            aProject.getDetail().getClasses().get(0);
        }

        return aProject;
    }

    @Override
    @Transactional
    public List<Project> getProjects(){
        return projectDAO.getProjects();
    }

    @Override
    @Transactional
    public List<Project> getProjectByName(String search){return projectDAO.getProjectByName(search);}

    @Override
    @Transactional
    public void saveProject(Project theProject){
        projectDAO.saveProject(theProject);
    }
}
