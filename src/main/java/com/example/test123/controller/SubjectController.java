package com.example.test123.controller;

import com.example.test123.jpa.Subject123;
import com.example.test123.service.ServiseInterfaces.SubjectService;
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

        List<Subject123> subject123List=subjectService.findAll();
        ModelAndView modelAndView = new ModelAndView("Subject/subject-table");
        model.addAttribute(subject123List);
        subjectService.findAll();
        return modelAndView;
    }

    @RequestMapping(value = "/add-subject", method = RequestMethod.GET)
    public @ResponseBody ModelAndView goToSubjectView(){
        ModelAndView modelAndView = new ModelAndView("Subject/add-subject");
        return modelAndView;
    }

    @RequestMapping(value = "/delete-subject", method = RequestMethod.GET)
    public @ResponseBody ModelAndView goToDeleteSubjectView(){
        ModelAndView modelAndView = new ModelAndView("Subject/delete-subject");
        return modelAndView;
    }

    @RequestMapping(value = "/subject-delete", method = RequestMethod.GET)
    public String deleteSubject (@RequestParam Long id,Model model) {
        subjectService.deleteSubject(id);
        List<Subject123> subject123List=subjectService.findAll();
        model.addAttribute(subject123List);

        return "Subject/subject-table";
    }

    @RequestMapping(value = "/subject-add", method = RequestMethod.POST)
    public String addSubject (@RequestParam(value = "name", required=false) String name,Model model) {
        Subject123 subject123 = new Subject123(name);
        subjectService.addSubject(subject123);
        List<Subject123> subject123List=subjectService.findAll();
        model.addAttribute(subject123List);
        return "Subject/subject-table";
    }
}
