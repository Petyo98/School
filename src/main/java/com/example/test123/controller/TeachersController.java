package com.example.test123.controller;

import com.example.test123.jpa.School112;
import com.example.test123.jpa.Subject123;
import com.example.test123.jpa.Teachers123;
import com.example.test123.service.ServiseInterfaces.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeachersController {

    @Autowired
    TeachersService teachersService;

    @RequestMapping(value="/teachers", method= RequestMethod.GET)
    public @ResponseBody
    ModelAndView showTeachers(Model model){

        List<Teachers123> teachers123List=teachersService.findAll();
        ModelAndView modelAndView = new ModelAndView("Teacher/teacher-table");
        model.addAttribute(teachers123List);
        return modelAndView;
    }

    @RequestMapping(value = "/delete-teacher", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewDeleteTeacher() {
        ModelAndView modelAndView = new ModelAndView("Teacher/delete-teacher");
        return modelAndView;
    }

    @RequestMapping(value = "/teacher-delete", method = RequestMethod.GET)
    public String deleteTeacher (@RequestParam Long id,Model model) {
        teachersService.deleteTeacher(id);
        List<Teachers123> teachers123List=teachersService.findAll();
        model.addAttribute(teachers123List);
        return "Teacher/teacher-table";
    }


    @RequestMapping(value = "/add-teacher", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("Teacher/add-teacher");
        return modelAndView;
    }

    @RequestMapping(value = "/add-teacher", method = RequestMethod.POST)
    public String addTeacher (@RequestParam(value = "name", required=false) String name,
                              @RequestParam(value = "subject123", required=false) School112 school112,
                              @RequestParam(value = "school112", required=false) Subject123 subject123,Model model) {
        Teachers123 teachers123 = new Teachers123(name,school112,subject123);
        teachersService.addTeacher(teachers123);
        List<Teachers123> school112List = teachersService.findAll();
        model.addAttribute(school112List);
        return "Teacher/teacher-table";
    }
}
