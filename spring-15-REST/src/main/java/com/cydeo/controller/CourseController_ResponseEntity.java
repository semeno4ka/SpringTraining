package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public ResponseEntity<List <CourseDTO>> getAllCourses(){//Modifications to output
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //custom status and headers
                .header("Version","Cydeo V.2")
                .header("Operation", "Get List")
                .body(courseService.getCourses());// whatever is the output, should be within body
    }

    @GetMapping("{id}")
    public ResponseEntity <CourseDTO> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity.ok(courseService.getCourseById(id)); // ok will go with default status and header structure
    }

    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getByCategory(@PathVariable("name") String name){
        return ResponseEntity.ok(courseService.getCoursesByCategory(name));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(courseService.createCourse(course));
    }
}
