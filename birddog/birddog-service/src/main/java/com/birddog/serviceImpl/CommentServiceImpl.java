/**
 * 
 */
package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.Comment;
import com.birddog.repository.CommentRepository;
import com.birddog.service.CommentService;
import com.birddog.service.LeadService;
import com.birddog.util.DateUtil;
import com.birddog.util.IConstant;

/**
 * @author Dell
 *
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired CommentRepository commentRepository;
	
	@Autowired
	LeadService leadService;

	public void save(Comment object) {
		object.setUpdationTime(DateUtil.todayDate());
		object.setCreationTime(DateUtil.todayDate());
		object.setIsDeleted(IConstant.ZERO);
		 commentRepository.save(object);
	}

	public List<Comment> getAll() {
	
		return null;
	}

	public Comment update(int id) {
		
		return null;
	}

	public void delete(int id) {
		
	}

	public boolean saveComment(Comment comment) {
		comment.setUpdationTime(DateUtil.todayDate());
		comment.setCreationTime(DateUtil.todayDate());
		comment.setIsDeleted(IConstant.ZERO);
		Comment userComment = commentRepository.save(comment);
		if (userComment != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<Comment> getAllComment(Integer id) {
		List<Comment> list =commentRepository.findByLeadId(id);
		for (Comment comment : list) {
			comment.setLead(null);
        }
		return list;
	}

}
