package com.birddog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.birddog.model.Birddog;
import com.birddog.model.Login;
import com.birddog.repository.ReInvestorRepository;
import com.birddog.service.BirddogRegistrationService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.EncryptDecrypt;
import com.birddog.util.IConstant;
import com.birddog.util.SendMail;

/**
 * 
 * @author Aartek
 *
 */
@Controller
public class BirddogRegistrationController {

	@Autowired
	private BirddogRegistrationService birddogRegistrationService;
	
	@Autowired
	private ReInvestorRepository reInvestorRepository;

	@RequestMapping(value = ConstantURL.BIRDDOG_REGISTRATION_URL, method = { RequestMethod.GET })
	public String showRegistrationPage(@ModelAttribute("Birddog") Birddog birddog,
					@RequestParam(required = false) String REI, ModelMap model) throws Exception {

		String decryptedId = EncryptDecrypt.decrypt(REI);
		Integer investorId = Integer.parseInt(decryptedId);
		model.addAttribute(IConstant.REI_ID, investorId);

		return IConstant.BIRDDOG_REGISTRATION;
	}

	@RequestMapping(value = ConstantURL.SAVE_BIRDDOG_REGISTRATION_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String saveUserInformation(@ModelAttribute("Birddog") Birddog birddog, ModelMap model) {
		birddog.setReInvestor(reInvestorRepository.findOne(birddog.getReInvestor().getId()));
		birddogRegistrationService.save(birddog);
		String Message ="Dear " +birddog.getReInvestor().getName()+"\n\n"
						+ "There is a New Birddog added to your Network\n"
						+ "Birddog Name = "+birddog.getName()+" \n"
										+ "Contact number = "+birddog.getContactNo()+"\n"
														+ "Mail = "+birddog.getEmail()+"\n\n"
																		+ "Regards, \n"
																		+ "Birddog System" ;
		System.out.println(Message);
		 SendMail.commomMailSend(birddog.getReInvestor().getEmail(), "notification", Message);
		model.addAttribute(IConstant.MESSAGE, ConstantMessage.BIRDDOG_REGISTRATION_SUCCESS_MESSAGE);

		return "redirect:" + ConstantURL.LOGIN_URL;
	}

	@RequestMapping(value = ConstantURL.DELETE_BIRDDOG_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteBirddog(ModelMap model, @RequestParam(required = false) Integer birddogId) {
		birddogRegistrationService.delete(birddogId);
		model.addAttribute(IConstant.MESSAGE, ConstantMessage.BIRDDOG_DELETE_MESSAGE);
		return "redirect:" + ConstantURL.VIEW_BIRDDOGS_URL;
	}

	@RequestMapping(value = ConstantURL.SHOW_BIRDDOG_CHANGE_PASSWORD_PAGE_URL, method = { RequestMethod.GET,
					RequestMethod.POST })
	public String showChangeBirddogPassword(@ModelAttribute("Login") Login login, ModelMap model, String message) {
		model.addAttribute("message", message);
		return IConstant.BIRDDOG_CHANGE_PASSWORD;
	}

	@RequestMapping(value = ConstantURL.BIRDDOG_CHANGE_PASSWORD_URL, method = { RequestMethod.GET,
					RequestMethod.POST })
	public String changePassword(@ModelAttribute("Login") Login login, ModelMap model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Birddog birddog = (Birddog) httpSession.getAttribute("birddog");
		boolean status = false;
		status = birddogRegistrationService.changeBirddogPassword(login.getOldPassword(), login.getNewPassword(),
						birddog.getId());
		if (status) {
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		} else {
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_FAILUR_MESSAGE);
		}
		return "redirect:" + ConstantURL.SHOW_BIRDDOG_CHANGE_PASSWORD_PAGE_URL;

	}
	
	@RequestMapping(value = ConstantURL.VERIFY_USER_EMAILID, method = { RequestMethod.GET})
	@ResponseBody
	public boolean verifyUserEmailId(@RequestParam(required = false) String emailId) {
		boolean status = birddogRegistrationService.verifyUserEmailId(emailId);
		return status;

	}
}
