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

import com.birddog.model.UploadTutorial;
import com.birddog.service.SuperAdminUploadTutorialService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class ViewTutorial {

	@Autowired
	private SuperAdminUploadTutorialService superAdminUploadTutorialService;
	
	@RequestMapping(value = ConstantURL.VIEW_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> viewTutorials(@RequestBody UploadTutorial uploadTutorial, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<UploadTutorial> tutorials = superAdminUploadTutorialService.getAllTutorial(uploadTutorial.getRoleId(),uploadTutorial.getType());
		if (tutorials != null &&!tutorials.equals("")) {	
			for(UploadTutorial tutorial:tutorials){
				tutorial.setLink(IConstant.BIRDDOG_URL+tutorial.getLink());
			}
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, tutorials);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.RECORD_NOT_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> viewSingleTutorials(@RequestBody UploadTutorial uploadTutorial, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		UploadTutorial tutorial = superAdminUploadTutorialService.getTutorialById(uploadTutorial.getId());
		if (tutorial != null &&!tutorial.equals("")) {	
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			tutorial.setLink(IConstant.BIRDDOG_URL+tutorial.getLink());
			map.put(IConstant.MESSAGE, tutorial);
			
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.RECORD_NOT_FOUND);
		}
		return map;
	}
	

}
