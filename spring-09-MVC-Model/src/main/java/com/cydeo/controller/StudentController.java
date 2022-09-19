package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){
        //use method of Model interface
        model.addAttribute("name","Cydeo");// name holds Cydeo
        model.addAttribute("course","MVC");// name is ATTRIBUTE and this attribute is used in Thymeleaf template to hold the data
        // we create a variable which will be used from DB later for dynamic data

        return "/student/welcome";// no html extension because it is converted to thymeleaf
    }
}
