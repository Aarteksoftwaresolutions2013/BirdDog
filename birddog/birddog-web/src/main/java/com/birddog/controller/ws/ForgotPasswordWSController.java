package com.birddog.controller.ws;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.birddog.model.Login;
import com.birddog.service.BirddogRegistrationService;
import com.birddog.service.LoginService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class ForgotPasswordWSController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BirddogRegistrationService birddogRegistrationService;
	
	@RequestMapping(value = ConstantURL.BIRDDOG_FORGOT_PASSWORD_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getBirddogEmail(@RequestBody Login login,
					HttpServletResponse response) {
		boolean status = false;
		Map<Object, Object> map = new HashMap<Object, Object>();
		status = loginService.findByEmailPassword(login.getEmail());
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.WS_MESSAGE, ConstantMessage.FORGOT_PASSWORD_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.WS_MESSAGE, ConstantMessage.FORGOT_PASSWORD_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.BIRDDOG_WS_CHANGE_PASSWORD, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> birddigChangePassword(@RequestBody Login login, 
					HttpServletResponse response) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = false;
		status = birddogRegistrationService.changeBirddogPassword(login.getOldPassword(), login.getNewPassword(),
						login.getId());
		if (status) {
			map.put(IConstant.WS_MESSAGE, ConstantMessage.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.WS_MESSAGE, ConstantMessage.CHANGE_PASSWORD_FAILUR_MESSAGE);
		}
		return map;
	}
	
}
