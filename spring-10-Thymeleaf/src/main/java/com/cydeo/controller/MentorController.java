package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")// will be concatinated to every end point
public class MentorController {


    @RequestMapping("/register")//localhost:8080/register
    public String register(){
        return "student/register";
    }
    @RequestMapping("/drop")//localhost:8080/register
    public String drop(){
        return "student/drop";
    }
}
