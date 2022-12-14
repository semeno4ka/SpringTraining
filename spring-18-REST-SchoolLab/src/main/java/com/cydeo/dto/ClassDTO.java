
package com.cydeo.dto;

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
public class ClassDTO {

    @JsonIgnore// you should keep ID info from user and not allow inputs
    private Long id;

    private String name;
    private Integer year;

    private CourseDTO course;

    private TeacherDTO teacher;

}