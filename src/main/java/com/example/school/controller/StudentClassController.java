package com.example.school.controller;

import com.example.school.jpa.StudentClass;
import com.example.school.service.StudentClassService;
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
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showClass(Model model) {

        List<StudentClass> studentClassList = studentClassService.findAll();
        ModelAndView modelAndView = new ModelAndView("Class/class-table");
        model.addAttribute(studentClassList);
        return modelAndView;
    }

    @RequestMapping(value = "/add-class", method = RequestMethod.POST)
    public String addClass(@RequestParam(value = "name", required = false) String name, Model model) {
        StudentClass studentClass = new StudentClass(name);
        studentClassService.save(studentClass);

        List<StudentClass> studentClassList = studentClassService.findAll();
        model.addAttribute(studentClassList);
        return "Class/add-class";
    }

    @RequestMapping(value = "/add-class", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToShowClass() {
        ModelAndView model = new ModelAndView("Class/add-class");
        return model;
    }

    @RequestMapping(value = "/class-delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteClass(@RequestParam Long id, Model model) {
        studentClassService.delete(id);
        List<StudentClass> studentClassList = studentClassService.findAll();
        model.addAttribute(studentClassList);
        return "Class/clazz-table";
    }

    @RequestMapping(value = "/delete-class", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goShowClass() {
        ModelAndView modelAndView = new ModelAndView("Class/delete-class");
        return modelAndView;
    }


}
