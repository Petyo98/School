package com.example.school.controller;

import com.example.school.jpa.School;
import com.example.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true, 10));
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToSecondPage(Model modelMap) {
        List<School> schoolList = schoolService.findAll();
        ModelAndView modelAndView = new ModelAndView("School/school-table");
        modelMap.addAttribute(schoolList);
        return modelAndView;
    }

    @RequestMapping(value = "/add-school", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToAddSchoolForm() {
        ModelAndView modelAndView = new ModelAndView("School/add-school");
        return modelAndView;
    }

    @RequestMapping(value = "/add-school", method = RequestMethod.POST)
    public String addSchool(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "createdyear", required = false) Date createdyear,Model model) {
        School school = new School(name, createdyear);
        schoolService.save(school);
        List<School> schoolList = schoolService.findAll();
        model.addAttribute(schoolList);
        return "School/school-table";
    }

    @RequestMapping(value = "/delete-school", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewDeleteSchool() {
        ModelAndView modelAndView = new ModelAndView("School/delete-school");
        return modelAndView;
    }

    @RequestMapping(value = "/school-delete", method = RequestMethod.GET)
    public String deleteSchool(@RequestParam Long id, Model model) {

        schoolService.delete(id);
        List<School> schoolList = schoolService.findAll();
        model.addAttribute(schoolList);
        return "School/school-table";
    }

    @RequestMapping(value = "/edit-school", method = RequestMethod.GET)
    public ModelAndView goEditSchool(@RequestParam Long id ,Model model) {
        School school = schoolService.getSchoolById(id);
        model.addAttribute("id",id);
        ModelAndView modelAndView = new ModelAndView("edit-school");

        return modelAndView;
    }

    @RequestMapping(value = "/school-edit", method = RequestMethod.POST)
    public String editSchool(@RequestParam Long id,@RequestParam String name,@RequestParam Date createdYear ) {
        School school = schoolService.getSchoolById(id);
        school.setName(name);
        school.setCreatedYear(createdYear);

        schoolService.save(school);
        schoolService.findAll();

        return "School/school-table";
    }

}
