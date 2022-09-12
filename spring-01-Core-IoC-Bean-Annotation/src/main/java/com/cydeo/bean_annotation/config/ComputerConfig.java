package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {


        @Bean(name="sony")// we customize the bean name in order to use it as a parameter later
        public Monitor monitorSony(){
        return new SonyMonitor("25 inch Beast","Sony",25);// Monitor abc= new SonyMonitor
        }
      @Bean
      @Primary //if we use Primary it will be used as default method, then in this case no bean name is required as parameter in container object creation
        public Monitor monitorAcer(){// Primary works if we have more than one same type of object
                return new AcerMonitor("23 inch Beast","Acer",23);// Monitor abc= new SonyMonitor
        }  //   BEAN SHOULD BE UNIQUE!!! HAVE TO USE JUST ONE OBJECT unless you call second Option from another specific class AcerMonitor*/
        @Bean
        public Case caseDell(){
        return new DellCase("4K","Dell","220");
        }
        @Bean
        public Motherboard motherboardAsus(){
        return new AsusMotherboard("G7","Asus",24,10,"v1.32");
        }
    }

