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

@Configuration
public class ComputerConfig {


        @Bean
        public Monitor monitorSony(){
        return new SonyMonitor("25 inch Beast","Sony",25);// Monitor abc= new SonyMonitor
        }
       /* @Bean
        public Monitor monitorAcer(){
                return new AcerMonitor("23 inch Beast","Acer",23);// Monitor abc= new SonyMonitor
        }    BEAN SHOULD BE UNIQUE!!! HAVE TO USE JUST ONE OBJECT unless you call second Option from another specific class AcerMonitor*/
        @Bean
        public Case caseDell(){
        return new DellCase("4K","Dell","220");
        }
        @Bean
        public Motherboard motherboardAsus(){
        return new AsusMotherboard("G7","Asus",24,10,"v1.32");
        }
    }

