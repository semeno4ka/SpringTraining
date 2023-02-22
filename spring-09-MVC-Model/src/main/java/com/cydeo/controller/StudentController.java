package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {
        //use method of Model interface
        model.addAttribute("name", "Cydeo");// name holds Cydeo
        model.addAttribute("course", "MVC");// name is ATTRIBUTE and this attribute is used in Thymeleaf template to hold the data
        // we create a variable which will be used from DB later for dynamic data

        String subject = "Spring Boot";
        model.addAttribute("subject", subject);
        int studentId = new Random().nextInt();
        model.addAttribute("id", studentId);
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        model.addAttribute("numbers", numbers);
        LocalDate dt = LocalDate.now();
        model.addAttribute("date", dt);
        Student student = new Student(123, "Bakha", "Bakhov");
        model.addAttribute("student", student);
        return "/student/welcome";// no html extension because it is converted to thymeleaf
    }
}
