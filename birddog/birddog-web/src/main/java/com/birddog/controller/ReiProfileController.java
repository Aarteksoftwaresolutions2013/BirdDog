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

import com.birddog.model.AccountSettings;
import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.service.CityService;
import com.birddog.service.CountyService;
import com.birddog.service.ReInvestorProfileService;
import com.birddog.service.StateService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;
import com.birddog.util.ImageFormat;
import com.birddog.util.ImageUtil;
import com.birddog.util.PaymentInterval;

@Controller
public class ReiProfileController {

    @Autowired
    private ReInvestorProfileService reInvestorProfileService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountyService countyService;

    @Autowired
    private CityService cityService;

    /**
     * This method is use for disply the city,state,country on jsp
     * 
     * @param reInvestor
     * @param model
     * @param reiId
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/reiProfile", method = RequestMethod.GET)
    public String showReiProfilePage(@ModelAttribute("ReInvestor") ReInvestor reInvestor, ModelMap model,
                    @RequestParam(required = false) Integer reiId) throws IOException {
        reInvestor = reInvestorProfileService.getReiById(reiId);
        if (reInvestor.getImageName() != null && !reInvestor.getImageName().isEmpty()) {
            String image = ImageFormat.readReiImage(reInvestor.getImageName());
            model.addAttribute("image", image);
        }
        if (reInvestor.getAddress() != null) {

            model.addAttribute("cities",
                            cityService.findCityByCountyId(reInvestor.getAddress().getCity().getCounty().getId()));
            model.addAttribute("counties", countyService
                            .findCountyByStateId(reInvestor.getAddress().getCity().getCounty().getState().getId()));
        }
        model.addAttribute("states", stateService.getAllStates());
        model.addAttribute("reInvestor", reInvestor);
        model.addAttribute("reiId", reiId);
        return "reiProfile";
    }

    /**
     * This method is use for save the reiInvestor information
     * 
     * @param reInvestor
     * @param model
     * @return
     */

    @RequestMapping(value = "/saveReiProfile", method = { RequestMethod.GET, RequestMethod.POST })
    private String saveUserInformation(@RequestParam("file") MultipartFile file,
                    @ModelAttribute("ReInvestor") ReInvestor reInvestor, ModelMap model, HttpServletRequest request) {
        reInvestorProfileService.save(reInvestor);
        HttpSession session = request.getSession();
        ReInvestor investor = (ReInvestor) session.getAttribute("investor");
        if (file != null && !file.isEmpty()) {
            String imageName = ImageUtil.saveReInvestorImage(file, investor.getId());
            reInvestorProfileService.saveImages(imageName, investor.getId());
        }
        model.addAttribute("message", ConstantMessage.PROFILE_UPDATE_SUCCESS_MESSAGE);

        return "redirect:" + ConstantURL.WELCOME_URL;
    }

    @RequestMapping(value = ConstantURL.VIEW_REI_URL, method = RequestMethod.GET)
    public String showReiProfilePage(ModelMap model, @RequestParam(required = false) Integer reiId) {
        ReInvestor reInvestor = reInvestorProfileService.getReiById(reiId);
        model.addAttribute("reInvestor", reInvestor);
        return IConstant.VIEW_REI;
    }

    @RequestMapping(value = ConstantURL.SHOW_REI_CHANGE_PASSWORD_PAGE_URL, method = { RequestMethod.GET,
                    RequestMethod.POST })
    public String showChangeSuperAdminPassword(@ModelAttribute("Login") Login login, ModelMap model, String message) {
        model.addAttribute("message", message);
        return IConstant.REI_CHANGE_PASSWORD;
    }

    @RequestMapping(value = ConstantURL.REI_CHANGE_PASSWORD_URL, method = { RequestMethod.GET, RequestMethod.POST })
    public String changePassword(@ModelAttribute("Login") Login login, ModelMap model, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        ReInvestor reInvestor = (ReInvestor) httpSession.getAttribute("investor");
        boolean status = false;
        status = reInvestorProfileService.changeReInvestorPassword(login.getOldPassword(), login.getNewPassword(),
                        reInvestor.getId());
        if (status) {
            model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        } else {
            model.addAttribute(IConstant.MESSAGE, ConstantMessage.CHANGE_PASSWORD_FAILUR_MESSAGE);
        }
        return "redirect:" + ConstantURL.SHOW_REI_CHANGE_PASSWORD_PAGE_URL;

    }

    // showAccountSetting
    @RequestMapping(value = ConstantURL.SHOW_ACCOUNT_SETTING_URL, method = RequestMethod.GET)
    public String showAccountSetting(ModelMap model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        ReInvestor investor = (ReInvestor) session.getAttribute(IConstant.INVESTOR);
        AccountSettings accountSettings = reInvestorProfileService.getAccountSettings(investor.getId());
        if (accountSettings != null) {
            model.addAttribute("accountSettings", accountSettings);
        } else {
            model.addAttribute("accountSettings", new AccountSettings());
        }
        model.addAttribute("investor",investor);
        model.addAttribute("paymentIntervals",PaymentInterval.getPaymentIntervals());
        
        return IConstant.REI_ACCOUNT_SETTING;
    }

    // saveAccountSettings
    @RequestMapping(value = "/saveAccountSettings", method = { RequestMethod.GET, RequestMethod.POST })
    private String saveAccountSettings(@ModelAttribute("accountSettings") AccountSettings accountSettings,
                    ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        ReInvestor investor = (ReInvestor) session.getAttribute("investor");
        accountSettings.setReInvestor(investor);
        reInvestorProfileService.saveAccountSettings(accountSettings);
        model.addAttribute("message", ConstantMessage.PROFILE_UPDATE_SUCCESS_MESSAGE);

        return "redirect:" + ConstantURL.SHOW_ACCOUNT_SETTING_URL;
    }

}
