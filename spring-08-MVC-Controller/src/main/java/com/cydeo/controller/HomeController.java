package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")// if you do not specify, it will be added as default to initial page localhost:8080
    public String home() {
        return "home.html";
    }

    @RequestMapping({"/apple", "/banana"})// CAN'T have two end points with same name in different methods,
    public String home2() {                    //because server will not know which one to choose
        return "home.html";
    }

}
