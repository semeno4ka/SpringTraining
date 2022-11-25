package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
@RequestMapping("/info")  //info?make=Honda
public String carInfo(@RequestParam String make, Model model){
    model.addAttribute("make",make);//(make is key, should match)end point, browser link end
    return "/car/car-info";
}


    @RequestMapping("/info2")// end point, browser link end
    public String carInfo2(@RequestParam(value = "make",required = false, defaultValue = "KIA") String make, Model model){

        model.addAttribute("make",make);

        return "/car/car-info";
    }


    @RequestMapping("/info3")// end point, browser link end
    public String carInfo3(@RequestParam() String make,@RequestParam int year, Model model){
// localhost:1010/input3?make=honda&year=2050
        model.addAttribute("make",make);
        model.addAttribute("year", year);
        return "/car/car-info";
    }
    @RequestMapping("/info/{make}/{age}")
    public String getCarInfo(@PathVariable String make, @PathVariable int age){
        System.out.println(make);
        System.out.println(age);
    return "/car/car-info";
    }
}// localhost:2020/info/honda(kia,nissan whatever)  //{ make }- represents dynamic data
