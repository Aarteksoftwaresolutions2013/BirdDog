package com.birddog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.UploadTutorial;
import com.birddog.service.SuperAdminUploadTutorialService;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class BirddogTutorialController {

	@Autowired
	private SuperAdminUploadTutorialService superAdminUploadTutorialService;

	
	@RequestMapping(value = ConstantURL.VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN_URL, method = { RequestMethod.GET })
	public String viewReiTutorialBySuperAdmin(ModelMap model,@RequestParam(required = false) Integer roleId, String type) {
		List<UploadTutorial> tutorialList = superAdminUploadTutorialService.getAllTutorial(roleId, type);
		model.addAttribute("tutorialList", tutorialList);
		return IConstant.VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN;
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewSingleTutorialRei( ModelMap model,@RequestParam(required = false) Integer tutorialId,Integer roleId,String type,String message) {
		UploadTutorial tutorial = superAdminUploadTutorialService.getTutorialById(tutorialId);
		model.addAttribute("tutorial",tutorial);
		return IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN;
	}
	

	@RequestMapping(value = ConstantURL.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR_URL, method = { RequestMethod.GET })
	public String viewBirddogTutorialByInvestor(ModelMap model,@RequestParam(required = false) Integer roleId, String type) {
		List<UploadTutorial> tutorialList = superAdminUploadTutorialService.getAllTutorial(roleId, type);
		model.addAttribute("tutorialList", tutorialList);
		return IConstant.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR;
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewSingleBirddogTutorialByInvestor( ModelMap model,@RequestParam(required = false) Integer tutorialId,Integer roleId,String type,String message) {
		UploadTutorial tutorial = superAdminUploadTutorialService.getTutorialById(tutorialId);
		model.addAttribute("tutorial",tutorial);
		return IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR;
	}
	
}
