package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)// not to see null fields in json response
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
//No need to annotate enum to get string response
    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference") // defaultReference based on name which should be unique
    private StudentDTO student;
    @JsonBackReference(value = "parent-address-reference") // defaultReference, names should be created unique
    private ParentDTO parent;
    @JsonBackReference(value = "teacher-address-reference")// defaultReference,names should be created unique
    private TeacherDTO teacher;

    private Integer currentTemperature;// Weather information, which we will later get it from 3rd party API
//we do not put Weather info to our db, we should keep it null till we start consuming API
}