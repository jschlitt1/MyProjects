package edu.wctc.service;

import edu.wctc.entity.Project;

import java.util.List;

public interface ProjectService {

    void deleteProject(int theID);

    Project getProject(int theID);

    Project getProjectAndClass(int ProjectID);

    List<Project> getProjects();

    List<Project> getProjectByName(String search);

    void saveProject(Project theProject);
}
