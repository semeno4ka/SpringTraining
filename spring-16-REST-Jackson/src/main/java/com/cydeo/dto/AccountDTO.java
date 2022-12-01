package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"address","country","state"}, ignoreUnknown = true)
// specify set of fields You would like to ignore
//if unknown comes from outside, do not add
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore//can't get can't post
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    // will hide UserDto from account(will not serialize) but you still can send this info, unlike JsonIgnore
    @JsonBackReference
    private UserDTO user;

}
