package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {
    @RequestMapping("/mentor")
    public String mentorPage(Model model){
        //could have been done as List and thus mentorList "mentors -> mentors.get(0).getFistName etc
        Mentor m1=new Mentor("Mike","Smith",45, Gender.MALE);
        Mentor m2=new Mentor("Tom","Hanks",65, Gender.MALE);
        Mentor m3=new Mentor("Ammy","Bryan",25, Gender.FEMALE);
        model.addAttribute("mentor1",m1);
        model.addAttribute("mentor2",m2);
        model.addAttribute("mentor3",m3);

        return "/student/mentor";
    }
}
