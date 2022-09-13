package com.cydeo.workingApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cydeo")
//ComponentScan(basePackages = { "com.cydeo.proxy","com.cydeo.service","com.cydeo.repository"}); HOW TO LIST PACKAGES
//model is not included, because there are no @Component ever
public class CommentConfig {
}
