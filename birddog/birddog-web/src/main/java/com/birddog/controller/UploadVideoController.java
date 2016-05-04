/*package com.birddog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.birddog.model.SuperAdmin;
import com.birddog.service.SuperAdminService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;
import com.birddog.util.ImageUtil;

@Controller
public class UploadVideoController {

	@Autowired
	private SuperAdminService superAdminService;
	
	@RequestMapping(value = ConstantURL.UPLOAD_VIEDO_URL, method = { RequestMethod.GET })
	public String showRegistrationPage(@ModelAttribute("SuperAdmin") SuperAdmin superAdmin, ModelMap model,String message){
		model.addAttribute("message", message);
		return IConstant.UPLOAD_VIEDO;
	}
	
	@RequestMapping(value = ConstantURL.UPLOAD_SUPER_ADMIN_VIEDO_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String uploadSuperAdminVideo(@RequestParam("file") MultipartFile file,
					@ModelAttribute("SuperAdmin") SuperAdmin superAdmin, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SuperAdmin admin = (SuperAdmin) session.getAttribute("superAdmin");
		if (file != null && !file.isEmpty()) {
			String videoName = ImageUtil.uploadSuperAdminVideo(file, admin.getId());
			superAdminService.saveSuperAdminVideo(videoName, admin.getId());
		}
		model.addAttribute("message", ConstantMessage.PROFILE_UPDATE_SUCCESS_MESSAGE);
		return "redirect:" + ConstantURL.UPLOAD_VIEDO_URL;
	}
}
*/