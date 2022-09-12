package com.cydeo.streotype_annotation.casefactory;

import org.springframework.stereotype.Component;

@Component // instead of beans, just use one annotation
public class DellCase extends Case  {

    public DellCase() {
        super("2208","Dell","240");
    }



    public void pressPowerButton() {

        System.out.println("Power button pressed");
    }
}
