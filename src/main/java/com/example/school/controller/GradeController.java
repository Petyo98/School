package com.example.school.controller;

import com.example.school.jpa.Grade;
import com.example.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class GradeController {

    @Autowired
    GradeService gradesService;

    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showGrades(Model model) {
        List<Grade> gradeList = gradesService.findAll();
        ModelAndView modelAndView = new ModelAndView("Grades/grades-table");
        model.addAttribute(gradeList);

        return modelAndView;
    }

    @RequestMapping(value = "/add-grades", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addGrade() {
        ModelAndView modelAndView = new ModelAndView("Grades/add-grades");
        return modelAndView;
    }

    @RequestMapping(value = "/add-grades", method = RequestMethod.POST)
    public String addGrade(@RequestParam(value = "value", required = false) Integer value, Model model) {
        Grade grade = new Grade(value);
        gradesService.save(grade);

        List<Grade> gradeList = gradesService.findAll();
        model.addAttribute(gradeList);

        return "Grades/add-grades";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteGrade() {
        ModelAndView model = new ModelAndView("Grades/delete-grades");
        return model;
    }

    @RequestMapping(value = "/delete-grades", method = RequestMethod.GET)
    public String deleteGrade(@RequestParam Long id, Model model) {
        gradesService.delete(id);
        List<Grade> gradeList = gradesService.findAll();

        model.addAttribute(gradeList);
        return "Grades/grades-table";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editGrade() {
        ModelAndView model = new ModelAndView("Grades/edit-grades");
        return model;
    }

    @RequestMapping(value = "/edit-grades", method = RequestMethod.POST)
    public String editGrade(Grade grade) {
        gradesService.save(grade);
        return "Grades/grades-table";
    }
}
