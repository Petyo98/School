package com.example.test123.controller;

import com.example.test123.jpa.Grades123;
import com.example.test123.service.ServiseInterfaces.GradesService;
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
public class GradesController {

    @Autowired
    GradesService gradesService;

    @RequestMapping(value = "/grades",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showGrades(ModelMap modelMap){
        List<Grades123> grades123List=gradesService.findAll();
        ModelAndView modelAndView = new ModelAndView("Grades/grades-table");
        modelMap.addAttribute(grades123List);
        return modelAndView;
    }

    @RequestMapping(value = "/add-grades", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addGrades() {
        ModelAndView modelAndView = new ModelAndView("Grades/add-grades");
        return modelAndView;
    }

    @RequestMapping(value = "/add-grades", method = RequestMethod.POST)
    public String doAction (@RequestParam(value = "value", required=false) Integer value, Model model) {
        Grades123 grades123= new Grades123(value);
        gradesService.addGrades(grades123);
        List<Grades123> grades123List=gradesService.findAll();
        model.addAttribute(grades123List);
        return "Grades/add-grades";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView goToDeleteGrades () {
        ModelAndView model = new ModelAndView("Grades/delete-grades");
        return model;
    }

    @RequestMapping(value = "/delete-grades", method = RequestMethod.GET)
    public String deleteGrades (@RequestParam Long id,Model model) {
        gradesService.deleteGrades(id);
        List<Grades123> grades123List=gradesService.findAll();
        model.addAttribute(grades123List);
        return "Grades/grades-table";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView go () {
        ModelAndView model = new ModelAndView("Grades/edit-grades");
        return model;
    }

    @RequestMapping(value = "/edit-grades", method = RequestMethod.POST)
    public String editGrades (Grades123 grades123) {
        gradesService.editGrades(grades123);
        return "Grades/grades-table";
    }
}
