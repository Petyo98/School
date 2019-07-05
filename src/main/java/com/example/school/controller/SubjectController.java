package com.example.school.controller;

import com.example.school.jpa.Subject;
import com.example.school.service.SubjectService;
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
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/subjects",method = RequestMethod.GET)
    public @ResponseBody ModelAndView showSubjects(Model model){

        List<Subject> subjectList=subjectService.findAll();
        ModelAndView modelAndView = new ModelAndView("Subject/subject-table");
        model.addAttribute(subjectList);
        subjectService.findAll();
        return modelAndView;
    }

    @RequestMapping(value = "/add-subject", method = RequestMethod.GET)
    public @ResponseBody ModelAndView addSubject(){
        ModelAndView modelAndView = new ModelAndView("Subject/add-subject");
        return modelAndView;
    }

    @RequestMapping(value = "/subject-add", method = RequestMethod.POST)
    public String addSubject (@RequestParam(value = "name", required=false) String name,Model model) {
        Subject subject = new Subject(name);
        subjectService.save(subject);
        List<Subject> subjectList=subjectService.findAll();
        model.addAttribute(subjectList);
        return "Subject/subject-table";
    }

    @RequestMapping(value = "/delete-subject", method = RequestMethod.GET)
    public @ResponseBody ModelAndView deleteSubject(){
        ModelAndView modelAndView = new ModelAndView("Subject/delete-subject");
        return modelAndView;
    }

    @RequestMapping(value = "/subject-delete", method = RequestMethod.GET)
    public String deleteSubject (@RequestParam Long id,Model model) {
        subjectService.delete(id);
        List<Subject> subjectList=subjectService.findAll();
        model.addAttribute(subjectList);

        return "Subject/subject-table";
    }
}
