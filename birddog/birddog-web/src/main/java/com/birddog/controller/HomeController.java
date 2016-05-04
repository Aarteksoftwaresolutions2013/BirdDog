package com.birddog.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.Birddog;
import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.model.SuperAdmin;
import com.birddog.service.BirddogService;
import com.birddog.service.LoginService;
import com.birddog.service.ReInvestorService;
import com.birddog.service.SuperAdminService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.EncryptDecrypt;
import com.birddog.util.IConstant;
import com.birddog.util.ImageFormat;

/**
 * @author Aartek
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private BirddogService birddogService;

	@Autowired
	private ReInvestorService reInvestorService;

	@Autowired
	private SuperAdminService superAdminService;
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = ConstantURL.HOME_URL, method = RequestMethod.GET)
	public String showHome(Model model, @RequestParam(required = false) String message) {

		model.addAttribute(IConstant.MESSAGE, message);
		logger.info("-----------welcome------------");
		return IConstant.HOME;
	}

	/**
	 * login
	 * 
	 * @param error
	 * @param logout
	 * @param message
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = ConstantURL.LOGIN_URL, method = RequestMethod.GET)
	public String login(@RequestParam(value = IConstant.ERROR, required = false) String error,
					@RequestParam(value = IConstant.LOGOUT, required = false) String logout,
					@RequestParam(required = false) String message, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute(IConstant.MESSAGE, message);

		if (error != null) {

			model.addAttribute(IConstant.MESSAGE, ConstantMessage.WRONG_CREDENTIAL);
		}

		if (logout != null) {

			model.addAttribute(IConstant.MESSAGE, ConstantMessage.RIGHT_CREDENTIAL);
		}

		return IConstant.HOME;
	}

	@RequestMapping(value = ConstantURL.WELCOME_URL, method = RequestMethod.GET)
	public String LoginSuccess(HttpServletRequest request, Principal principal, ModelMap model, String message)
					throws Exception {

		HttpSession session = request.getSession();
		String userName = principal.getName();

		if (request.isUserInRole(IConstant.USER_ROLE_BIRDDOG)) {

			Birddog birddog = birddogService.getLoggedInUserInfo(userName);
			session.setAttribute(IConstant.BIRDDOG, birddog);
			if (birddog != null) {
				model.addAttribute("birddog", birddog);
				model.addAttribute("message", message);
				if (birddog.getImageName() != null && !birddog.getImageName().isEmpty()) {
					String image = ImageFormat.readBirddogProfileImage(birddog.getImageName());
					model.addAttribute("image", image);
				}
			}
			return IConstant.BIRDDOG_HOME;
		} else if (request.isUserInRole(IConstant.USER_ROLE_RE_INVESTOR)) {

			ReInvestor investor = reInvestorService.getLoggedInUserInfo(userName);
			session.setAttribute(IConstant.INVESTOR, investor);
			String encryptedId = EncryptDecrypt.encrypt(Integer.toString(investor.getId()));
			session.setAttribute(IConstant.INVESTOR_ID, ConstantURL.INVESTOR_URL + "" + encryptedId + "");

			if (investor != null) {
				model.addAttribute("reInvestor", investor);
				model.addAttribute("message", message);
				if (investor.getImageName() != null && !investor.getImageName().isEmpty()) {
					String image = ImageFormat.readReiImage(investor.getImageName());
					model.addAttribute("image", image);
				}
			}
			return IConstant.INVESTOR_HOME;
		} else if (request.isUserInRole(IConstant.USER_ROLE_SUPER_ADMIN)) {

			SuperAdmin superAdmin = superAdminService.getLoggedInUserInfo(userName);
			session.setAttribute(IConstant.SUPER_ADMIN, superAdmin);

			if (superAdmin != null) {
				model.addAttribute("superAdmin", superAdmin);
				model.addAttribute("message", message);
				if (superAdmin.getImageName() != null && !superAdmin.getImageName().isEmpty()) {
					String image = ImageFormat.readSuperAdminImage(superAdmin.getImageName());
					model.addAttribute("image", image);
				}
			}

			return IConstant.SUPER_ADMIN_HOME;
		} else {

			model.addAttribute(IConstant.MESSAGE, ConstantMessage.WRONG_CREDENTIAL);

			return "redirect:" + ConstantURL.HOME_URL;
		}

	}

	@RequestMapping(value = ConstantURL.CANCEL_URL, method = RequestMethod.GET)
	public String showHomePage() {
		return "redirect:" + ConstantURL.WELCOME_URL;

	}
	
	@RequestMapping(value = ConstantURL.SHOW_FORGOT_PASSWORD_PAGE_URL, method = RequestMethod.GET)
	public String showForgotPasswordPage(@ModelAttribute("Login") Login login,String message) {
		return IConstant.FORGOT_PASSWORD;

	}
	
	@RequestMapping(value = ConstantURL.FORGOT_PASSWORD, method = { RequestMethod.GET, RequestMethod.POST })
	public String forgotPassword(@ModelAttribute("Login") Login login, ModelMap model) {
		boolean status=false;
		status = loginService.findByEmailPassword(login.getEmail());
		if(status){
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.FORGOT_PASSWORD_SUCCESS_MESSAGE);
		}else{
			model.addAttribute(IConstant.MESSAGE, ConstantMessage.FORGOT_PASSWORD_FAILUR_MESSAGE);
		}
		return "redirect:" + ConstantURL.HOME_URL;

	}


}
