package edu.wctc.controller;

import edu.wctc.entity.ClassOb;
import edu.wctc.service.ClassService;
import edu.wctc.service.LocationService;
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
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    public String listClasses(Model theModel){
        //get from service
        List<ClassOb> classList = classService.getClasses();
        //add list to the model
        theModel.addAttribute("classes", classList);
        //send the view
        return "listClasses";
    }

    @GetMapping("/ClassInfo")
    public String ClassInfo(@RequestParam("classId") int theID, Model theModel){
        //Get the Class
        ClassOb theClass = classService.getClass(theID);
        //set in the model
        theModel.addAttribute("aClass", theClass);

        return "ClassInfo";
    }

    @RequestMapping("/admin/showAddClassForm")
    public String showAddClassForm(Model theModel){
        ClassOb theClass = new ClassOb();

        theModel.addAttribute("aClass", theClass);
        theModel.addAttribute("locations", locationService.getLocations());
        theModel.addAttribute("skills", skillService.getSkills());

        return "classForm";
    }

    @RequestMapping("/admin/showUpdateClassForm")
    public String showUpdateProjectForm(@RequestParam("classId") int theID, Model theModel){
        //Get the Project
        ClassOb theClass = classService.getClass(theID);
        //set in the model
        theModel.addAttribute("aClass", theClass);
        theModel.addAttribute("locations", locationService.getLocations());
        theModel.addAttribute("skills", skillService.getSkills());
        //return view
        return "classForm";
    }

    @PostMapping("/admin/save")
    public String saveDonut(@Valid @ModelAttribute("aClass") ClassOb theClass, BindingResult bindingResult, Model theModel)
    {
        //validation errors?
        if(bindingResult.hasErrors()){
             //push errors to console
            System.err.println(bindingResult);
            theModel.addAttribute("locations", locationService.getLocations());
            theModel.addAttribute("skills", skillService.getSkills());
            //send back with errors
            return "classForm";
        }
        //update the project
        classService.saveClass(theClass);
        //return back to the list
        return "redirect:/class/list";
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
