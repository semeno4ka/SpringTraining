package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v1")//best practice for creating endpoints for different versions
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    //@ResponseBody Let Spring know we are not working with a view in this method
    public List<CourseDTO> getAllCourses(){// Not String html file anymore, but the data

        return courseService.getCourses();
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCoursesByCategory(@PathVariable("name") String categoryName){
        return courseService.getCoursesByCategory(categoryName);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
         return courseService.createCourse(course);
    }

    @PutMapping("{id}")      // findById                 Object to be updated
    public void updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id,courseDTO);
    }
    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long id){
        courseService.deleteCourseById(id);
    }

}
