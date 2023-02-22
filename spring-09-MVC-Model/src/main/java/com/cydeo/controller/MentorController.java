package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {
    @RequestMapping("/mentor")
    public String mentorPage(Model model) {// need to add to list to iterate it in edited html file
        //could have been done as List and thus mentorList "mentors -> mentors.get(0).getFistName etc
        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Mike", "Smith", 45, Gender.MALE));
        mentors.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentors.add(new Mentor("Ammy", "Bryan", 25, Gender.FEMALE));
        model.addAttribute("mentor", mentors);

        return "/student/mentor";
    }
}
