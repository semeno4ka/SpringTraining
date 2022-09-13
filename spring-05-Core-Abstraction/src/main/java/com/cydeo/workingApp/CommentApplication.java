package com.cydeo.workingApp;

import com.cydeo.workingApp.config.CommentConfig;
import com.cydeo.workingApp.model.Comment;
import com.cydeo.workingApp.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApplication {
    public static void main(String[] args) {

     Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}