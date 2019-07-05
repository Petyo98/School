package com.example.test123.controller;

import com.example.test123.jpa.School;
import com.example.test123.jpa.Subject;
import com.example.test123.jpa.Teacher;
import com.example.test123.service.TeacherService;
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
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showTeachers(Model model) {

        List<Teacher> teachersList = teacherService.findAll();
        ModelAndView modelAndView = new ModelAndView("Teacher/teacher-table");
        model.addAttribute(teachersList);
        return modelAndView;
    }

    @RequestMapping(value = "/delete-teacher", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView deleteTeacher() {
        ModelAndView modelAndView = new ModelAndView("Teacher/delete-teacher");
        return modelAndView;
    }

    @RequestMapping(value = "/teacher-delete", method = RequestMethod.GET)
    public String deleteTeacher(@RequestParam Long id, Model model) {
        teacherService.delete(id);
        List<Teacher> teachersList = teacherService.findAll();
        model.addAttribute(teachersList);
        return "Teacher/teacher-table";
    }


    @RequestMapping(value = "/add-teacher", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addTeacher() {
        ModelAndView modelAndView = new ModelAndView("Teacher/add-teacher");
        return modelAndView;
    }

    @RequestMapping(value = "/add-teacher", method = RequestMethod.POST)
    public String addTeacher(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "subject", required = false) Subject subject,
                             @RequestParam(value = "school", required = false) School school, Model model) {
        Teacher teacher = new Teacher(name, school, subject);
        teacherService.save(teacher);

        List<Teacher> schoolList = teacherService.findAll();
        model.addAttribute(schoolList);
        return "Teacher/teacher-table";
    }
}
