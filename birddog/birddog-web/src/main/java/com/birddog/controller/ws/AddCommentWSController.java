package com.birddog.controller.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.birddog.model.Comment;
import com.birddog.model.Lead;
import com.birddog.service.CommentService;
import com.birddog.service.LeadService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class AddCommentWSController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = ConstantURL.BIRDDOG_ADDCOMMENT_WS_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAddBirddogComment(@RequestBody Comment comment,
					HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = false;
		if (comment != null) {
		status = commentService.saveComment(comment);
		}
		if (status) {
			map.put(IConstant.WS_MESSAGE, ConstantMessage.ADD_COMMENT_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.WS_MESSAGE, ConstantMessage.ADD_COMMENT_FAILIUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.GET_ALL_COMMENT_WS_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllComment(@RequestBody Lead lead,
					HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (lead.getId() != null) {
		List<Comment> commentList = commentService.getAllComment(lead.getId());
		if (commentList!=null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, commentList);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, commentList);
		}
		}
		return map;
	}
	
	
}
