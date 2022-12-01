package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")//Rememeber that we work with DTO only
    public List<TeacherDTO> readAllTeacher() {
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved", studentService.findAll()));
    }// with OK we can pass the data directly as parameter

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper =
                new ResponseWrapper(true, "Parents are retrieved successfully",
                        HttpStatus.OK.value(), parentService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
    }// with status we need to continue with BODY in order to pass the data

    @GetMapping("/address/{id}")//we throw an exception because our findById throws exception for No Address
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception {
        AddressDTO addressDTO = addressService.findById(id);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressDTO));
    }

    @PutMapping("/address/{id}")//RequestBody for catching the changed address in Request Body
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);// since our ID is Ignored in Jason, we need to catch it from url
        return addressService.update(addressDTO);
    }

}
