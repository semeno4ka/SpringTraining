package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PCConfig;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComTest {
    public static void main(String[] args) {

        ApplicationContext container= new AnnotationConfigApplicationContext(PCConfig.class);// adds(scans for a class) from PCConfig which are annotated with Component

        Monitor monitor1=container.getBean(Monitor.class);
        System.out.println(monitor1.getSize());
    }
}
