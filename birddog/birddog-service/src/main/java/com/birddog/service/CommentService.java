package com.birddog.service;

import java.util.List;

import com.birddog.model.Comment;

public interface CommentService extends Service<Comment> {

	boolean saveComment(Comment comment);

	List<Comment> getAllComment(Integer id);

}
