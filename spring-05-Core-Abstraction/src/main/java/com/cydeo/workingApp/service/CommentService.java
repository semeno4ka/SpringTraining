package com.cydeo.workingApp.service;

import com.cydeo.workingApp.proxy.CommentNotificationProxy;
import com.cydeo.workingApp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.cydeo.workingApp.model.Comment;
@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;// use final in order ti not forget about constructor

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
       commentRepository.storeComment(comment);
       commentNotificationProxy.sendComment(comment);
        //save in the DB + send email
    }
}
