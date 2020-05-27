package edu.wctc.dao;

import edu.wctc.entity.Project;

import java.util.List;

public interface ProjectDAO {
    List<Project> getProjects();

    void saveProject(Project theProject);

    Project getProject(int theID);

    void deleteProject(int theID);

    List<Project> getProjectByName(String search);
}
