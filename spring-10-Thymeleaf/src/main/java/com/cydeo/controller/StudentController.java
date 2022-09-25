package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller@RequestMapping("/student")// you define the path here, so that you do not have to add it every time as /student/register, /student/homepage
public class StudentController {

    @RequestMapping("/register")//localhost:8080/register -> student can be skipped, it is annotated on Class level
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());// we create student objects which will be seen (that is why model is needed)
        return "student/register";// Thymeleaf uses ATTRIBUTE NAME
    }
    @RequestMapping("/drop")
    public String drop(){

        return "student/drop";
    }

    @RequestMapping("/welcome")// student/welcome
    public String welcome(){
      //  System.out.println(name);//can move it to DB
        return "student/welcome";// the exact page you will also use as URL link @{}
    }
}
