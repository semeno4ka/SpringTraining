package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// user can write, but not retrieve
    private String password;// send password to DB but not from
    private String username;
    private UserRole role;
    @JsonManagedReference// show Accountdto in user
    private AccountDTO account;

}
