package com.example.school.controller;

import com.example.school.jpa.Student;
import com.example.school.service.StudentService;
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
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showStudents(Model model) {

        List<Student> studentsList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("Student/student-table");
        model.addAttribute(studentsList);
        return modelAndView;

    }

    @RequestMapping(value = "/add-student", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addStudents() {

        ModelAndView modelAndView = new ModelAndView("Student/add-student");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-student", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView deleteStudent() {

        ModelAndView modelAndView = new ModelAndView("Student/delete-student");

        return modelAndView;
    }

    @RequestMapping(value = "/student-delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam Long id, Model model) {
        studentService.delete(id);

        List<Student> studentsList = studentService.findAll();
        model.addAttribute(studentsList);
        return "Student/student-table";
    }

    @RequestMapping(value = "/student-add", method = RequestMethod.POST)
    public String addStudent(@RequestParam(value = "name", required = false) String name) {
        Student student = new Student(name);

        studentService.save(student);
        studentService.findAll();

        return "Student/student-table";
    }
}
