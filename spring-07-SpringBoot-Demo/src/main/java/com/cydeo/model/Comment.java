package com.cydeo.model;

import jdk.jfr.DataAmount;
import lombok.Data;


@Data
public class Comment {
    private String author;
    private String text;// models never get @Component

}
