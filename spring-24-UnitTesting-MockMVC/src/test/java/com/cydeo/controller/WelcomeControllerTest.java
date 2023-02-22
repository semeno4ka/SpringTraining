package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    //Controller Unit testing
    @Autowired// we do not used Contructor, just field Injection for testing
    private MockMvc mvc;

    @Test
    void welcomeTest() throws Exception {//not used a lot
        //call welcome endpoint and verify response is "welcome"
        RequestBuilder request= MockMvcRequestBuilders.get("/welcome")//to build request, use RequestBuilder
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome",result.getResponse().getContentAsString());
    }

    @Test
    void welcomeTest2() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/welcome")//to build request, use RequestBuilder
                .accept(MediaType.APPLICATION_JSON);
        //does same thing we do in postman: input endpoint, choose request time, and mediatype
        mvc.perform(request)// same as send button in postman
                .andExpect(status().isOk())//verify status
                .andExpect(content().string("welcome"))//what is the body
                .andReturn();
    }
}
