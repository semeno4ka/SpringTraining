package com.cydeo.workingApp.proxy;

import com.cydeo.workingApp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);// interfaces never get @Component
}
