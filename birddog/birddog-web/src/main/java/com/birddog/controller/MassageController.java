package com.birddog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.birddog.model.Birddog;
import com.birddog.model.Message;
import com.birddog.model.ReInvestor;
import com.birddog.service.MessageService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class MassageController {
	
	@Autowired
	MessageService messageService;

	@RequestMapping(value = ConstantURL.SEND_MESSAGE_URL, method = RequestMethod.GET)
	public String sendMassage(ModelMap model,String message) {
		model.addAttribute(IConstant.MESSAGE, new Message());
		model.addAttribute("success", message);
		return IConstant.SEND_MESSAGE;
	}

	@RequestMapping(value = ConstantURL.SAVE_MESSAGE_URL, method = RequestMethod.POST)
	public String saveMessage(@ModelAttribute("Message") Message message, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		ReInvestor reInvestor = (ReInvestor) session.getAttribute(IConstant.INVESTOR);
		message.setReInvestor(reInvestor);
		messageService.save(message);
		model.addAttribute(IConstant.MESSAGE, ConstantMessage.SAVE_SUCCESS_MESSAGE);
		return "redirect:" + IConstant.SEND_MESSAGE;

	}

	@RequestMapping(value = ConstantURL.MESSAGE_URL, method = RequestMethod.GET)
	public String message(ModelMap model, HttpServletRequest request) {
		model.addAttribute(IConstant.MESSAGE, new Message());

		HttpSession session = request.getSession();

		Birddog birddog = ((Birddog) session.getAttribute(IConstant.BIRDDOG));

		List<Message> messages = messageService.getMessage(birddog.getReInvestor().getId());
		model.addAttribute(IConstant.MESSAGE_LIST, messages);
		return IConstant.BIRDDOG_MESSAGE;

	}

}
