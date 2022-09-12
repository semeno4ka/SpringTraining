package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.TestConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, TestConfig.class);// container is created, it is empty
// since constructor accepts class, '.class' is required, thus we specify where the container will look for required configurations
        // How to add beans? Two ways we will be using: @Bean and stereotype annotations
   // Monitor theMonitor=container.getBean(Monitor.class);
        SonyMonitor theMonitor=container.getBean(SonyMonitor.class);// we have an error right now
    Case theCase=container.getBean(Case.class);
    Motherboard theMotherBoard=container.getBean(Motherboard.class);

 PC myPC=new PC(theCase,theMonitor,theMotherBoard);
 myPC.powerUp();
//PC hisPC=new PC(container.getBean(Case.class),container.getBean(Monitor.class),container.getBean(Motherboard.class));
//hisPC.powerUp();


        System.out.println("                 Multiple Objects            ");
        Monitor theMonitor2= container.getBean("sony",Monitor.class);// we have s String parameter representing the name of the METHOD as DEFAULT BEAN NAME
PC myPc2= new PC(theCase,theMonitor,theMotherBoard); //"sony" is used as custom bean name
myPc2.powerUp();

    }
}
