package com.example.test123.controller;

import com.example.test123.jpa.Students123;
import com.example.test123.service.ServiseInterfaces.StudentsService;
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
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showStudents(Model model){

        List<Students123> students123List =studentsService.findAll();
        ModelAndView modelAndView = new ModelAndView("Student/student-table");
        model.addAttribute(students123List);
        return modelAndView;

    }

    @RequestMapping(value = "/add-student", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToAddStudents(){

        ModelAndView modelAndView = new ModelAndView("Student/add-student");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-student", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToDeleteStudent(){

        ModelAndView modelAndView = new ModelAndView("Student/delete-student");

        return modelAndView;
    }

    @RequestMapping(value = "/student-delete", method = RequestMethod.GET)
    public String deleteStudent (@RequestParam Long id, Model model) {
        studentsService.deleteStudent(id);
        List<Students123> students123List =studentsService.findAll();
        model.addAttribute(students123List);
        return "Student/student-table";
    }

    @RequestMapping(value = "/student-add", method = RequestMethod.POST)
    public String addStudent (@RequestParam(value = "name", required=false) String name) {
        Students123 students123= new Students123(name);
        studentsService.addStudent(students123);
        studentsService.findAll();
        return "Student/student-table";
    }
}
