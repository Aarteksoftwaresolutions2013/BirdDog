package com.birddog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.Birddog;
import com.birddog.model.SendMail;
import com.birddog.service.ReInvestorGroupMailingService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;

@Controller
public class ReInvestorGroupMailingController {
	
	@Autowired
	private ReInvestorGroupMailingService reInvestorGroupMailingService;
	
	@RequestMapping(value = ConstantURL.GROUP_MAIL_TO_BIRDDOG_URL, method = RequestMethod.GET)
	public String groupMailToBirddog(@ModelAttribute("SendMail") SendMail sendMail,@RequestParam(required = false) Integer reiId,ModelMap model,String message) {
		List<Birddog> birddogs= reInvestorGroupMailingService.getAllbirddogById(reiId);
		model.addAttribute("birddogsList", birddogs);
		model.addAttribute("message", message);
		model.addAttribute("reiId", reiId);
		return ConstantURL.GROUP_MAIL_TO_BIRDDOG;
	}
	
	
	@RequestMapping(value = ConstantURL.SEND_MAIL_TO_BIRDDOG_URL, method = RequestMethod.POST)
	public String sendMailToEmployee(@ModelAttribute("SendMail") SendMail sendMail,ModelMap model) {
		Integer reiId = sendMail.getReiId();
		if(sendMail.getToMailId()!=null){
			reInvestorGroupMailingService.sendMailToGroup(sendMail);
		   model.addAttribute("message", ConstantMessage.MAIL_SUCCESS_MESSAGE);
		   model.addAttribute("reiId", reiId);
		}else{
			model.addAttribute("message", ConstantMessage.MAIL_FAILUR_MESSAGE);
			 model.addAttribute("reiId", reiId);
		}
		return "redirect:"+ConstantURL.GROUP_MAIL_TO_BIRDDOG_URL;
	}
}
