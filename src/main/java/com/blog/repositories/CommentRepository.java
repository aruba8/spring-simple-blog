package com.blog.repositories;

import com.blog.model.Comment;

public interface CommentRepository {
    void save(Comment comment);
}
