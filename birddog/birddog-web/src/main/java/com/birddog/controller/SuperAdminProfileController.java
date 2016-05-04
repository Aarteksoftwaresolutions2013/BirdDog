package com.birddog.controller;

import java.io.IOException;

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
import com.birddog.service.CityService;
import com.birddog.service.CountyService;
import com.birddog.service.StateService;
import com.birddog.service.SuperAdminService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;
import com.birddog.util.ImageFormat;
import com.birddog.util.ImageUtil;

/**
 * 
 * @author Aartek
 *
 */
@Controller
public class SuperAdminProfileController {
	
	@Autowired
	private StateService stateService;

	@Autowired
	private CountyService countyService;

	@Autowired
	private CityService cityService;

	@Autowired
	private SuperAdminService superAdminService;

	/**
	 * This method is use for disply the city,state,country on jsp
	 * 
	 * @param superAdmin
	 * @param model
	 * @param superAdminId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/superAdminProfile", method = RequestMethod.GET)
	public String showReiProfilePage(@ModelAttribute("SuperAdmin") SuperAdmin superAdmin, ModelMap model,
					@RequestParam(required = false) Integer superAdminId) throws IOException {
		superAdmin = superAdminService.getSuperAdminById(superAdminId);
		if (superAdmin.getImageName() != null && !superAdmin.getImageName().isEmpty()) {
			String image = ImageFormat.readSuperAdminImage(superAdmin.getImageName());
			model.addAttribute("image", image);
		}
		if (superAdmin.getAddress() != null) {
			model.addAttribute("cities",
							cityService.findCityByCountyId(superAdmin.getAddress().getCity().getCounty().getId()));
			model.addAttribute(
							"counties",
							countyService.findCountyByStateId(superAdmin.getAddress().getCity().getCounty().getState()
											.getId()));
		}
		model.addAttribute("states", stateService.getAllStates());
		model.addAttribute("superAdmin", superAdmin);
		return IConstant.SUPER_ADMIN_PROFILE;
	}

	/**
	 * This method is use for save or update the superAdmin information
	 * 
	 * @param superAdmin
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveSuperAdminProfile", method = { RequestMethod.GET, RequestMethod.POST })
	private String saveUserInformation(@RequestParam("file") MultipartFile file,
					@ModelAttribute("SuperAdmin") SuperAdmin superAdmin, ModelMap model, HttpServletRequest request) {
		superAdminService.save(superAdmin);
		HttpSession session = request.getSession();
		SuperAdmin admin = (SuperAdmin) session.getAttribute("superAdmin");
		if (file != null && !file.isEmpty()) {
			String imageName = ImageUtil.saveSuperAdminImage(file, admin.getId());
			superAdminService.saveSuperAdminImages(imageName, admin.getId());
		}
		model.addAttribute("message", ConstantMessage.PROFILE_UPDATE_SUCCESS_MESSAGE);

		return "redirect:" + ConstantURL.WELCOME_URL;
	}
}
