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

import com.birddog.model.Message;
import com.birddog.model.ReInvestor;
import com.birddog.service.MessageService;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class MessageWSController {

	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = ConstantURL.GET_MESSAGE_WS_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllComment(@RequestBody ReInvestor reInvestor,
					HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (reInvestor.getId() != null) {
		List<Message> messageList = messageService.getAllMessage(reInvestor.getId());
		if (messageList!=null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, messageList);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, messageList);
		}
		}
		return map;
	}
}
