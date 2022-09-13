package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cydeo")//will look for component annotation throughout the entire com.cydeo package, package can be specified as well
public class PCConfig {
}
