package com.cydeo.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public String myString(){
        return "Cydeo";// you can do new String() but it will be empty
    }
    @Bean
    public Integer myInt(){
        return 5;
    }
}
