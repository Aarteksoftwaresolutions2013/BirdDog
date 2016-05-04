package com.birddog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.UploadTutorial;
import com.birddog.service.SuperAdminUploadTutorialService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class SuperAdminUploadReiTutorialController {

	@Autowired
	private SuperAdminUploadTutorialService superAdminUploadTutorialService;

	@RequestMapping(value = ConstantURL.TUTORIALS_URL, method = { RequestMethod.GET })
	public String viewTutorials() {

		return IConstant.VIEW_TUTORIAL;
	}

	@RequestMapping(value = ConstantURL.UPLOAD_TUTORIAL_REI_URL, method = { RequestMethod.GET })
	public String uploadTutorial(@ModelAttribute("UploadTutorial") UploadTutorial uploadTutorial, ModelMap model,
			String message, @RequestParam(required = false) Integer roleId, String type) {
		List<UploadTutorial> tutorialList = superAdminUploadTutorialService.getAllTutorial(roleId, type);
		model.addAttribute("tutorialList", tutorialList);
		model.addAttribute("message", message);
		model.addAttribute("roleId", roleId);
		model.addAttribute("type", type);
		return IConstant.UPLOAD_TUTORIAL_REI;
	}

	@RequestMapping(value = ConstantURL.SAVE_TUTORIAL_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String saveTutorial(@ModelAttribute("UploadTutorial") UploadTutorial uploadTutorial, ModelMap model) {
		UploadTutorial UploadVideo = superAdminUploadTutorialService.saveTutorial(uploadTutorial);
		model.addAttribute("message", ConstantMessage.SAVE_TUTORIAL_SUCCESS_MESSAGE);
		model.addAttribute("type", UploadVideo.getType());
		model.addAttribute("roleId", UploadVideo.getRoleId());
		return "redirect:" + ConstantURL.UPLOAD_TUTORIAL_REI_URL;
	}

	@RequestMapping(value = ConstantURL.UPDATE_SUPER_ADMIN_TUTORIAL_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String updateSuperAdminTutorial(@ModelAttribute("UploadTutorial") UploadTutorial uploadTutorial, ModelMap model,
			 @RequestParam(required = false) Integer tutorialId,Integer roleId,String type) {
		UploadTutorial tutorial = superAdminUploadTutorialService.getTutorialById(tutorialId);
		List<UploadTutorial> tutorialList = superAdminUploadTutorialService.getAllTutorial(roleId, type);
		model.addAttribute("tutorialList", tutorialList);
		model.addAttribute("UploadTutorial", tutorial);
		return IConstant.UPLOAD_TUTORIAL_REI;
	}
	
	@RequestMapping(value = ConstantURL.DELETE_SUPER_ADMIN_TUTORIAL_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String deleteSuperAdminTutorial( ModelMap model,@RequestParam(required = false) Integer tutorialId,Integer roleId,String type,String message) {
		superAdminUploadTutorialService.getTutorial(tutorialId);
		model.addAttribute("roleId",roleId);
		model.addAttribute("type",type);
		model.addAttribute("message",ConstantMessage.DELETE_TUTORIAL_SUCCESS_MESSAGE);
		return "redirect:" + ConstantURL.UPLOAD_TUTORIAL_REI_URL;
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_TUTORIAL_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewSingleTutorialRei( ModelMap model,@RequestParam(required = false) Integer tutorialId,Integer roleId,String type,String message) {
		UploadTutorial tutorial = superAdminUploadTutorialService.getTutorialById(tutorialId);
		model.addAttribute("tutorial",tutorial);
		return IConstant.VIEW_SINGLE_TUTORIAL_REI;
	}
	


}
