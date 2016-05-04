package com.birddog.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.model.SuperAdmin;
import com.birddog.service.ReInvestorService;
import com.birddog.service.SuperAdminService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

/**
 * @author Aartek
 *
 */
@Controller
public class SuperAdminController {

	@Autowired
	ReInvestorService reInvestorService;

	@Autowired
	private SuperAdminService superAdminService;

	@RequestMapping(value = ConstantURL.VIEW_REI_LIST_URL, method = RequestMethod.GET)
	public String showRegistrationPage(@ModelAttribute("ReInvestor") ReInvestor reInvestor,
			@RequestParam(required = false) String message, ModelMap model) {
		List<ReInvestor> investors = reInvestorService.getAll();
		model.addAttribute("investors", investors);
		model.addAttribute(IConstant.MESSAGE, message);

		return IConstant.REI_LIST;
	}

	@RequestMapping(value = ConstantURL.DELETE_INVESTOR_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteInvestor(ModelMap model, @RequestParam(required = false) Integer investorId) {
		reInvestorService.delete(investorId);
		model.addAttribute(IConstant.MESSAGE, ConstantMessage.INVESTOR_DELETE_MESSAGE);
		return "redirect:" + ConstantURL.VIEW_REI_LIST_URL;
	}

	@RequestMapping(value = ConstantURL.SEARCH_REI_CREATION_DATE_BY_ADMIN_URL, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String serachReiDateBySuperAdmin(@ModelAttribute("ReInvestor") ReInvestor reInvestor, ModelMap model)
			throws ParseException {
		List<ReInvestor> reInvestorList = reInvestorService.findAllBetweenDates(reInvestor.getFromDate(),
				reInvestor.getToDate(), reInvestor.getSearch());
		if(reInvestorList!=null && !reInvestorList.isEmpty()){
		model.addAttribute("investorsList", reInvestorList);
		}else{
			model.addAttribute("records",ConstantMessage.RECORD_NOT_FOUND );
		}
		return IConstant.REI_LIST;
	}
	
	@RequestMapping(value = ConstantURL.SHOW_ADMIN_CHANGE_PASSWORD_PAGE_URL, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String showChangeSuperAdminPassword(@ModelAttribute("Login") Login login, ModelMap model,String message) {
		model.addAttribute("message", message);
		return IConstant.SUPER_ADMIN_CHANGE_PASSWORD;
	}

	@RequestMapping(value = ConstantURL.SUPER_ADMIN_CHANGE_PASSWORD_URL, method = { RequestMethod.GET,
			RequestMethod.POST })
	public String changePassword(@ModelAttribute("Login") Login login, ModelMap model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		SuperAdmin superAdmin = (SuperAdmin) httpSession.getAttribute("superAdmin");
		boolean status = false;
		status = superAdminService.changeSuperAdminPassword(login.getOldPassword(), login.getNewPassword(),superAdmin.getId());
		if (status) {
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		} 
		else {
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_FAILUR_MESSAGE);
		}
		return "redirect:" + ConstantURL.SHOW_ADMIN_CHANGE_PASSWORD_PAGE_URL;
		
	}
}
