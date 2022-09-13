package com.cydeo.workingApp.repository;

import com.cydeo.workingApp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);//interfaces never get @Component
}
