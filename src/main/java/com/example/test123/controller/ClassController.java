package com.example.test123.controller;

import com.example.test123.jpa.Class123;
import com.example.test123.service.ServiseInterfaces.ClassService;
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
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/class",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showClass(Model model){

        List<Class123> class123List=classService.findAll();
        ModelAndView modelAndView = new ModelAndView("Class/class-table");
        model.addAttribute(class123List);
        return modelAndView;
    }

    @RequestMapping(value = "/add-class",method = RequestMethod.POST)
    public String addClass(@RequestParam(value = "name", required=false) String  name,Model model){
        Class123 class123= new Class123(name);
        classService.addClass(class123);
        List<Class123> class123List=classService.findAll();
        model.addAttribute(class123List);
        return "Class/add-class";
    }

    @RequestMapping(value = "/add-class",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToShowClass(){
        ModelAndView modeel = new ModelAndView("Class/add-class");
        return modeel;
    }

    @RequestMapping(value = "/class-delete",method = RequestMethod.GET)
    public @ResponseBody
    String deleteClass(@RequestParam Long id,Model model){
        classService.deleteClass(id);
        List<Class123> class123List=classService.findAll();
        model.addAttribute(class123List);
        return "Class/clazz-table";
    }

    @RequestMapping(value = "/delete-class",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView goShowClass(){
        ModelAndView modelAndView = new ModelAndView("Class/delete-class");
        return modelAndView;
    }



}
