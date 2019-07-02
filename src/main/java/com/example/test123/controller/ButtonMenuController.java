package com.example.test123.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ButtonMenuController {

    @RequestMapping(value="/index2", method=RequestMethod.GET)
    public @ResponseBody
    ModelAndView goToSecondPage(){
        ModelAndView model = new ModelAndView("button-menu");

        return model;
    }

}
