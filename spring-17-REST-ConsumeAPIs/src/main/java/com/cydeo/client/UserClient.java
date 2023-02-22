package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserClient {
    @GetMapping("/users")//adds it to consuming endpoint, was a part of endpoint initially, can either stay there or places separately
    List<User> getUsers();
}
