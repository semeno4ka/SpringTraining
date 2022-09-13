package com.cydeo.streotype_annotation.monitorfactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // if you do not add component there will be no error such as UNIQUE bean, because it is not a bean until annotated
@Primary
public class AcerMonitor extends Monitor{

    public AcerMonitor() {
        super("23 inch beast","Acer",23);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Acer");
    }
}
