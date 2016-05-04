package com.birddog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

	 @RequestMapping(value = "/returnPage", method = RequestMethod.GET)
	public String showReturnPage(Model model) {
		return "returnPage";
	}
	 
	 @RequestMapping(value = "/canclePage", method = RequestMethod.GET)
		public String showCanclePage(Model model) {
			return "canclePage";
		}
	 
	 @RequestMapping(value = "/notifyPage", method = {RequestMethod.GET, RequestMethod.POST})
		public String showNotifyPage(Model model) {
		 System.out.println("notifyPage");
			return "notifyPage";
		}

	
}
