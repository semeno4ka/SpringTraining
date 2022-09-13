package com.cydeo.workingApp.proxy;

import com.cydeo.workingApp.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification: "+comment.getText());// Should have has-a relationship (should be used as private description in another class)
    }

}
