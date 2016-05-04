package com.birddog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.ReInvestor;
import com.birddog.service.ReInvestorService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;
import com.birddog.util.ProductVersion;

/**
 * 
 * @author Aartek
 *
 */
@Controller
public class RegistrationController {
	
	@Autowired
	private ReInvestorService registrationService;

	@RequestMapping(value = ConstantURL.REGISTRATION_URL, method = RequestMethod.GET)
	public String showRegistrationPage(@RequestParam(required = false) String message,
					@ModelAttribute("ReInvestor") ReInvestor reInvestor, ModelMap model) {
        model.addAttribute("productVersions",ProductVersion.getProductVersions());
		model.addAttribute(IConstant.MESSAGE, message);

		return IConstant.REGISTRATION;
	}

	@RequestMapping(value = ConstantURL.SAVE_REGISTRATION_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String saveUserInformation(@ModelAttribute("ReInvestor") ReInvestor reInvestor, ModelMap model) {

		registrationService.save(reInvestor);
		model.addAttribute(IConstant.MESSAGE, ConstantMessage.MAIL_SUCCESS_MESSAGE);

		return "redirect:" + ConstantURL.REGISTRATION_URL;
	}

}
