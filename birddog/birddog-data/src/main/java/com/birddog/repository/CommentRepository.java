package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByLeadId(Integer leadId);

    List<Comment> findByLeadIdAndIsDeleted(Integer leadId, int zero);

	// List<Comment> findByLeadIdAndUserRoleId(Integer leadId, Integer
	// userRoleId);

}
