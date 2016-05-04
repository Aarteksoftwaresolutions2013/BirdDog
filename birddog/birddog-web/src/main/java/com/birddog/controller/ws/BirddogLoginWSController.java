package com.birddog.controller.ws;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.birddog.model.Birddog;
import com.birddog.model.Login;
import com.birddog.service.BirddogService;
import com.birddog.service.LoginService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class BirddogLoginWSController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BirddogService birddogService;
	
	@RequestMapping(value = ConstantURL.BIRDDOG_LOGIN_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getBirddogLoginDetail(@RequestBody Login login,
					HttpServletResponse response) {
		Birddog birddog = new Birddog();
		Map<Object, Object> map = new HashMap<Object, Object>();
		login = loginService.findByEmailPassword(login);
		if (login != null) {
			birddog = birddogService.findByEmail(login.getEmail());
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.BIRDDOG_ID, birddog.getId());
			map.put(IConstant.WS_MESSAGE, ConstantMessage.BIRDDOG_LOGIN_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.WS_MESSAGE, ConstantMessage.BIRDDOG_LOGIN_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.BIRDDOG_PROFILE_WS_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> viewbirddogProfile(@RequestBody Birddog birddog, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Birddog locator = birddogService.findByBirddogId(birddog.getId());
		if (locator != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, locator);
			map.put("imageName", IConstant.BIRDDOG_PROFILE_IMAGES+locator.getImageName());
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.BIRDDOG_NOT_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.UPDATE_BIRDDOG_PROFILE_WS_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> updateBirddogProfile(@RequestBody Birddog birddog, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		Birddog locator = birddogService.updateBirddogProfile(birddog);
		if (locator != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.UPDATE_BIRDDOG_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.UPDATE_BIRDDOG_NOT_MESSAGE);
		}
		return map;
	}
}
