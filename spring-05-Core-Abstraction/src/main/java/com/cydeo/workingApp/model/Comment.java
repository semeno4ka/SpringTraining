package com.cydeo.workingApp.model;

import lombok.Data;


@Data
public class Comment {
    private String author;
    private String text;// models never get @Component

}
