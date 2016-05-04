package com.birddog.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.birddog.model.Birddog;
import com.birddog.model.ReInvestor;
import com.birddog.service.BirddogService;
import com.birddog.service.CityService;
import com.birddog.service.CountyService;
import com.birddog.service.StateService;
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
public class BirddogProfileController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountyService countyService;

	@Autowired
	private CityService cityService;

	@Autowired
	private BirddogService birddogService;

	/**
	 * This method is use for disply the city,state,country on jsp
	 * 
	 * @param birddog
	 * @param model
	 * @param birddogId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = ConstantURL.BIRDDOG_PROFILE_URL, method = RequestMethod.GET)
	public String showReiProfilePage(@ModelAttribute("Birddog") Birddog birddog, ModelMap model,
					@RequestParam(required = false) Integer birddogId) throws IOException {
		birddog = birddogService.getBirddogById(birddogId);
		if (birddog.getImageName() != null && !birddog.getImageName().isEmpty()) {
			String image = ImageFormat.readBirddogProfileImage(birddog.getImageName());
			model.addAttribute("image", image);
		}
		if (birddog.getAddress() != null) {
			model.addAttribute("cities",
							cityService.findCityByCountyId(birddog.getAddress().getCity().getCounty().getId()));
			model.addAttribute(
							"counties",
							countyService.findCountyByStateId(birddog.getAddress().getCity().getCounty().getState()
											.getId()));
		}
		model.addAttribute("states", stateService.getAllStates());
		model.addAttribute(IConstant.BIRDDOG, birddog);
		return IConstant.BIRDDOG_PROFILE;
	}

	/**
	 * This method is use for save or update the birddog information
	 * 
	 * @param birddog
	 * @param model
	 * @return
	 */
	@RequestMapping(value = ConstantURL.SAVE_BIRDDOG_PROFILE_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String saveUserInformation(@RequestParam("file") MultipartFile file,
					@ModelAttribute("Birddog") Birddog birddog, ModelMap model, HttpServletRequest request) {
		birddogService.save(birddog);
		HttpSession session = request.getSession();
		Birddog locator = (Birddog) session.getAttribute("birddog");

		if (file != null && !file.isEmpty()) {

			String imageName = ImageUtil.saveBirddogImage(file, locator.getId());
			birddogService.saveBirddogImages(imageName, locator.getId());
		}

		model.addAttribute(IConstant.MESSAGE, ConstantMessage.PROFILE_UPDATE_SUCCESS_MESSAGE);

		return "redirect:" + ConstantURL.WELCOME_URL;
	}

	/**
	 * fetch all birddog under logged in REI
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = ConstantURL.VIEW_BIRDDOGS_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public String viewBirddogs(@ModelAttribute("Birddog") Birddog birddog, ModelMap model, HttpServletRequest request,String pay) {

		HttpSession session = request.getSession();
		ReInvestor investor = (ReInvestor) session.getAttribute(IConstant.INVESTOR);
		List<Birddog> birddogs = birddogService.getAllBirddogs(investor.getId());
		model.addAttribute(IConstant.BIRDDOGS, birddogs);
		model.addAttribute(IConstant.PAY, pay);
		return IConstant.BIRDDOG_LIST;
	}

	@RequestMapping(value = ConstantURL.VIEW_BIRDDOG_URL, method = RequestMethod.GET)
	public String showReiProfilePage(ModelMap model, @RequestParam(required = false) Integer birddogId) {
		Birddog birddog = birddogService.getBirddogById(birddogId);
		model.addAttribute(IConstant.BIRDDOG, birddog);
		return IConstant.VIEW_BIRDDOG;
	}

	@RequestMapping(value = ConstantURL.SEARCH_BIRDDOG_BY_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
	public String serchByDate(@ModelAttribute("Birddog") Birddog birddog, ModelMap model, HttpServletRequest request)
					throws ParseException {

		HttpSession session = request.getSession();
		ReInvestor investor = (ReInvestor) session.getAttribute(IConstant.INVESTOR);
		List<Birddog> listBirddog = birddogService.findAllBetweenDates(birddog.getFromDate(), birddog.getToDate(),
						birddog.getTxtSearch(),investor.getId());
		if(listBirddog!=null){
		model.addAttribute(IConstant.SERACH_BIRDDOG_LIST, listBirddog);
		}else{
			model.addAttribute(IConstant.RECORD_NOT_FOUND, ConstantMessage.RECORD_NOT_FOUND);
		}
		return IConstant.BIRDDOG_LIST;
	}
	
	@RequestMapping(value = ConstantURL.SEND_PAYMENT_URL, method = {RequestMethod.GET, RequestMethod.POST})
	public String showPaymentPage(@ModelAttribute("Birddog") Birddog birddog, ModelMap model) {
     if(birddog.getPayment()!=null && !birddog.getPayment().equals("")){
		model.addAttribute(IConstant.BIRDDOG, birddog.getPayment());
		model.addAttribute(IConstant.EMAIL, birddog.getEmail());
		return IConstant.VIEW_PAYMENT_PAGE;
     }else{
    	 model.addAttribute(IConstant.PAY, ConstantMessage.PAY_MESSAGE);
    	 return "redirect:" + ConstantURL.VIEW_BIRDDOGS_URL;
     }
		
	}
	

}
