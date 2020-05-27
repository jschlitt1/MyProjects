package edu.wctc.controller;

import edu.wctc.entity.ClassOb;
import edu.wctc.entity.Project;
import edu.wctc.service.ClassService;
import edu.wctc.service.ProjectService;
import edu.wctc.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    public String listProjects(Model theModel){
        //get from service
        List<Project> projectList = projectService.getProjects();
        //add list to the model
        theModel.addAttribute("projects", projectList);
        //send the view
        return "listProjects";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String searchTerm, Model theModel){
        List<Project> matchingProjects = projectService.getProjectByName(searchTerm);

        theModel.addAttribute("projects", matchingProjects);

        return "listProjects";
    }

    @GetMapping("/ProjectInfo")
    public String ProjectInfo(@RequestParam("projectId") int theID, Model theModel){
        //Get the Project
        Project theProject = projectService.getProject(theID);
        //set in the model
        theModel.addAttribute("aProject", theProject);
        theModel.addAttribute("classes", classService.getClasses());

        return "ProjectInfo";
    }

    @GetMapping("/admin/delete")
    public String deleteProject(@RequestParam("projectId") int theID){
        //delete it
        projectService.deleteProject(theID);
        return "redirect:/project/list";
    }

    @RequestMapping("/admin/showAddProjectForm")
    public String showAddProjectForm(Model theModel){
        Project theProject = new Project();

        theModel.addAttribute("aProject", theProject);
        theModel.addAttribute("classes", classService.getClasses());
        theModel.addAttribute("skills", skillService.getSkills());

        return "projectForm";
    }

    @RequestMapping("/admin/showUpdateProjectForm")
    public String showUpdateProjectForm(@RequestParam("projectId") int theID, Model theModel){
        //Get the Project
        Project theProject = projectService.getProject(theID);
        //set in the model
        theModel.addAttribute("aProject", theProject);
        theModel.addAttribute("classes", classService.getClasses());
        theModel.addAttribute("skills", skillService.getSkills());
        //return view
        return "projectForm";
    }

    @PostMapping("/admin/save")
    public String saveProject(@Valid @ModelAttribute("aProject") Project theProject, BindingResult bindingResult, Model theModel)
    {
        //validation errors?
        if(bindingResult.hasErrors()){
            //push errors to console
            System.err.println(bindingResult);
            //put list back into model
            theModel.addAttribute("classes", classService.getClasses());
            theModel.addAttribute("skills", skillService.getSkills());
            //send back with errors
            return "projectForm";
        }
        //update the project
        projectService.saveProject(theProject);
        //return back to the list
        return "redirect:/project/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringtrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringtrimmerEditor);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e){e.printStackTrace();}
}
