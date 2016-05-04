package com.birddog.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.birddog.model.Attachment;
import com.birddog.model.Birddog;
import com.birddog.model.City;
import com.birddog.model.Comment;
import com.birddog.model.County;
import com.birddog.model.Lead;
import com.birddog.model.ReInvestor;
import com.birddog.model.UserRole;
import com.birddog.service.AttachmentService;
import com.birddog.service.CityService;
import com.birddog.service.CommentService;
import com.birddog.service.CountyService;
import com.birddog.service.LeadService;
import com.birddog.service.StateService;
import com.birddog.util.BuiltYear;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.ConstructionType;
import com.birddog.util.IConstant;
import com.birddog.util.ImageFormat;
import com.birddog.util.ImageUtil;
import com.birddog.util.LeadApproval;
import com.birddog.util.LeadStatus;
import com.birddog.util.PersonalIndicators;
import com.birddog.util.Pool;
import com.birddog.util.PropertyType;
import com.birddog.util.RoofConstructionType;
import com.birddog.util.SellerMotivation;
import com.birddog.util.VerifyOccupancy;

@Controller
public class LeadController {

    @Autowired
    private LeadService leadService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountyService countyService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AttachmentService attachmentService;
    

    @Autowired
    private CommentService commentService;

    /**
     * Show lead page
     * 
     * @param lead
     * @param modelMap
     * @return
     */
    @RequestMapping(value = ConstantURL.ADD_LEAD_URL, method = RequestMethod.GET)
    public String showLeadPage(@ModelAttribute("Lead") Lead lead, ModelMap modelMap,
                    @RequestParam(required = false) String message) {
        modelMap.addAttribute("states", stateService.getAllStates());
        modelMap.addAttribute("message", message);
        modelMap.addAttribute("Lead", lead);
        modelMap.addAttribute("constructionType", ConstructionType.constructionType());
        modelMap.addAttribute("roofConstructionType", RoofConstructionType.roofConstruction());
        modelMap.addAttribute("pool", Pool.pool());
        modelMap.addAttribute("builtyear", BuiltYear.year());
        modelMap.addAttribute("sellerMotivation", SellerMotivation.sellerMotivation());
        modelMap.addAttribute("personalIndicators", PersonalIndicators.personalIndicatorsList());
        modelMap.addAttribute("verifyOccupancy", VerifyOccupancy.verifyOccupancy());
        modelMap.addAttribute("propertyType", PropertyType.propertyType());

        return IConstant.ADD_LEAD;
    }

    /**
     * Save lead
     * 
     * @param lead
     * @param modelMap
     * @return
     */
    @RequestMapping(value = ConstantURL.SAVE_LEAD_URL, method = { RequestMethod.GET, RequestMethod.POST })
    public String saveLead(@RequestParam("file") MultipartFile[] files, @ModelAttribute("Lead") Lead lead,
                    ModelMap modelMap, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        lead.setBirddog((Birddog) httpSession.getAttribute("birddog"));
        leadService.save(lead);
        attachmentService.saveImages(ImageUtil.saveImages(files, lead.getId()), lead);
        modelMap.addAttribute("message", IConstant.LEAD_SUCCESS);

        return "redirect:" + ConstantURL.VIEW_BIRDDOG_LEADS_URL;
    }

    /**
     * find state by counrtyId
     * 
     * @param countryId
     * @return
     */
    @RequestMapping(value = ConstantURL.COUNTY_BY_STATE_ID_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<County> getState(@RequestParam Integer stateId) {
        return countyService.findCountyByStateId(stateId);
    }

    /**
     * find city by countyId
     * 
     * @param countyId
     * @return
     */
    @RequestMapping(value = ConstantURL.CITY_BY_COUNTY_ID_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<City> getCity(@RequestParam Integer countyId) {
        return cityService.findCityByCountyId(countyId);
    }

    @RequestMapping(value = ConstantURL.VIEW_LEADS_URL, method = RequestMethod.GET)
    public String viewLeads(@ModelAttribute("Lead") Lead lead, ModelMap modelMap, HttpServletRequest request,
                    @RequestParam(required = false) String message) {
        HttpSession httpSession = request.getSession();
        ReInvestor reInvestor = ((ReInvestor) httpSession.getAttribute(IConstant.INVESTOR));
        List<Lead> leads = leadService.findAllLeadsByReiId(reInvestor.getId());
        modelMap.addAttribute("leadStatus", LeadStatus.leadStatus());
        modelMap.addAttribute(IConstant.LEADS, leads);
        modelMap.addAttribute("leadApproval", LeadApproval.leadApproval());
        modelMap.addAttribute(IConstant.MESSAGE, message);
        return IConstant.LEADS_LIST;
    }

    @RequestMapping(value = ConstantURL.VIEW_LEAD_URL, method = RequestMethod.GET)
    public String viewLead(ModelMap model, @RequestParam(required = false) Integer leadId) throws IOException {
        Lead lead = leadService.findOne(leadId);
        List<Comment> comments = leadService.getAllComments(leadId);
        List<Attachment> imageList = attachmentService.findImageNameById(lead.getId());
        List<String> images = new ArrayList<String>();
        if (imageList != null && !imageList.isEmpty()) {
            for (Attachment attachment : imageList) {
                images.add(ImageFormat.readImage(attachment.getPath()));
            }
        }
        model.addAttribute(IConstant.COMMENT, new Comment());
        model.addAttribute(IConstant.COMMENTS, comments);
        model.addAttribute(IConstant.IMAGES, images);
        model.addAttribute(IConstant.LEAD, lead);

        return IConstant.VIEW_LEAD;
    }

    @RequestMapping(value = ConstantURL.VIEW_BIRDDOG_LEADS_URL, method = RequestMethod.GET)
    public String viewBirddogLeads(@ModelAttribute("Lead") Lead lead, ModelMap modelMap, HttpServletRequest request,
                    @RequestParam(required = false) String message) {
        HttpSession httpSession = request.getSession();
        Birddog birddog = ((Birddog) httpSession.getAttribute(IConstant.BIRDDOG));
        List<Lead> leads = leadService.getAllLeadById(birddog.getId());
        modelMap.addAttribute(IConstant.LEADS, leads);
        modelMap.addAttribute(IConstant.MESSAGE, message);
        return IConstant.BIRDDOG_LEADS_LIST;
    }

    @RequestMapping(value = ConstantURL.VIEW_BIRDDOG_LEAD_URL, method = RequestMethod.GET)
    public String viewBirddogLead(ModelMap model, @RequestParam(required = false) Integer leadId) throws IOException {
        Lead lead = leadService.findOne(leadId);
        List<Attachment> imageList = attachmentService.findImageNameById(lead.getId());
        List<String> images = new ArrayList<String>();
        if (imageList != null && !imageList.isEmpty()) {
            for (Attachment attachment : imageList) {
                images.add(ImageFormat.readImage(attachment.getPath()));
            }
        }
        List<Comment> comments = leadService.getAllComments(leadId);
        model.addAttribute(IConstant.COMMENT, new Comment());
        model.addAttribute(IConstant.COMMENTS, comments);
        model.addAttribute(IConstant.IMAGES, images);
        model.addAttribute(IConstant.LEAD, lead);
        return IConstant.VIEW_BIRDDOG_LEAD;
    }

    @RequestMapping(value = ConstantURL.ADD_COMMENT_URL, method = RequestMethod.POST)
    public String addComment(@ModelAttribute("Comment") Comment comment, ModelMap modelMap,
                    HttpServletRequest request) {
        UserRole userRole = new UserRole();
        String action = null;
        if (request.isUserInRole(IConstant.USER_ROLE_BIRDDOG)) {
            userRole = leadService.getRoleByRoleId(IConstant.USER_ROLE_BIRDDOG_ID);
            action = IConstant.VIEW_BIRDDOG_LEAD;
        } else if (request.isUserInRole(IConstant.USER_ROLE_RE_INVESTOR)) {
            userRole = leadService.getRoleByRoleId(IConstant.USER_ROLE_RE_INVESTOR_ID);
            action = IConstant.VIEW_LEAD;
        }
        comment.setUserRole(userRole);
        commentService.save(comment);
        modelMap.addAttribute(IConstant.LEAD_ID, comment.getLead().getId());
        return "redirect:" + action;
    }

    @RequestMapping(value = ConstantURL.DELETE_LEAD_URL, method = RequestMethod.GET)
    public String deleteLead(@RequestParam(required = false) Integer leadId, ModelMap model,
                    HttpServletRequest request) {
        String action = null;
        if (request.isUserInRole(IConstant.USER_ROLE_BIRDDOG)) {
            action = ConstantURL.VIEW_BIRDDOG_LEADS_URL;
        } else if (request.isUserInRole(IConstant.USER_ROLE_RE_INVESTOR)) {
            action = ConstantURL.VIEW_LEADS_URL;
        }
        leadService.delete(leadId);
        model.addAttribute(IConstant.MESSAGE, ConstantMessage.LEAD_DELETE_MESSAGE);
        return "redirect:" + action;
    }

    @RequestMapping(value = ConstantURL.SEARCH_LEAD_BY_REI_URL, method = { RequestMethod.GET, RequestMethod.POST })
    public String serchByreiLeadDate(@ModelAttribute("Lead") Lead lead, ModelMap model) throws ParseException {
        List<Lead> listLead = leadService.findAllBetweenDates(lead.getFromDate(), lead.getToDate(), lead.getSearch());
        model.addAttribute(IConstant.SEARCH_LEADS, listLead);
        model.addAttribute("leadStatus", LeadStatus.leadStatus());
        model.addAttribute("leadApproval", LeadApproval.leadApproval());
        return IConstant.LEADS_LIST;
    }

    @RequestMapping(value = ConstantURL.SEARCH_LEAD_BY_BIRDDOG_DATE_URL, method = { RequestMethod.GET,
                    RequestMethod.POST })
    public String searchLeadByBirddogDate(@ModelAttribute("Lead") Lead lead, ModelMap model) throws ParseException {
        List<Lead> listLead = leadService.findAllBetweenDates(lead.getFromDate(), lead.getToDate(), lead.getSearch());
        model.addAttribute(IConstant.BIRDDOG_LEADS, listLead);
        model.addAttribute("leadStatus", LeadStatus.leadStatus());
        return IConstant.BIRDDOG_LEADS_LIST;
    }

    /**
     * Change lead status
     * 
     * @return
     */
    @RequestMapping(value = "updateLeadStatus", method = RequestMethod.GET)
    @ResponseBody
    public Boolean updateLeadStatus(@RequestParam Integer leadId, String status) {
        leadService.updateLeadStatus(leadId, status);
        return true;
    }

    @RequestMapping(value = "updateLeadApproval", method = RequestMethod.GET)
    @ResponseBody
    public Boolean updateLeadApproval(@RequestParam Integer leadId, String status) {
        leadService.updateLeadApproval(leadId, status);
        return true;
    }

    @RequestMapping(value = ConstantURL.UPDATE_BIRDDOG_LEAD_URL, method = { RequestMethod.GET, RequestMethod.POST })
    public String updateBirddogLead(@RequestParam(required = false) Integer leadId, ModelMap model) {
        Lead lead = leadService.update(leadId);
        model.addAttribute("Lead", lead);
        model.addAttribute("states", stateService.getAllStates());
        model.addAttribute("cities", cityService.findCityByCountyId(lead.getAddress().getCity().getCounty().getId()));
        model.addAttribute("counties",
                        countyService.findCountyByStateId(lead.getAddress().getCity().getCounty().getState().getId()));
        model.addAttribute("constructionType", ConstructionType.constructionType());
        model.addAttribute("roofConstructionType", RoofConstructionType.roofConstruction());
        model.addAttribute("pool", Pool.pool());
        model.addAttribute("builtyear", BuiltYear.year());
        model.addAttribute("sellerMotivation", SellerMotivation.sellerMotivation());
        model.addAttribute("personalIndicators", PersonalIndicators.personalIndicatorsList());
        model.addAttribute("verifyOccupancy", VerifyOccupancy.verifyOccupancy());
        model.addAttribute("propertyType", PropertyType.propertyType());
        String physical = lead.getPhysicalPropertyIndicators();
        String perIndicators = lead.getPersonalIndicators();
        if (physical != null) {
            model.addAttribute("phyIndicators", new ArrayList<String>(Arrays.asList(physical.split(","))));
        }
        if (perIndicators != null) {
            model.addAttribute("perIndicators", new ArrayList<String>(Arrays.asList(perIndicators.split(","))));
        }
        return IConstant.ADD_LEAD;
    }

    @RequestMapping(value = ConstantURL.SHOW_MAP_URL, method = { RequestMethod.GET, RequestMethod.POST })
    public String showMapPage(ModelMap model) {
    	model.addAttribute("city", cityService.getAllCity());
        return IConstant.SHOW_MAP;
    }

    @RequestMapping(value = "/getAllLeadListByBirddog", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody List<Lead> getAllLeadListBybirddog(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        ReInvestor reInvestor = (ReInvestor) httpSession.getAttribute("investor");
        List<Lead> mapDetailsList = leadService.getAllLeadListByBirddog(reInvestor.getId());
        for (Lead lead : mapDetailsList) {
            lead.getBirddog().setReInvestor(null);
        }
        return mapDetailsList;
    }

    @RequestMapping(value = ConstantURL.SEARCH_BY_BIRDDOG_ON_MAP_URL, method = { RequestMethod.GET,
                    RequestMethod.POST })
    public @ResponseBody List<Lead> searchByBirddogOnMap(@RequestParam(required = false) String search,
                    HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        ReInvestor reInvestor = (ReInvestor) httpSession.getAttribute("investor");
        List<Lead> leadListByName = leadService.getAllLeadsListByBirddogName(reInvestor.getId(), search);
        for (Lead lead : leadListByName) {
            lead.getBirddog().setReInvestor(null);
        }
        return leadListByName;
    }
    
    @RequestMapping(value = ConstantURL.SEARCH_BY_CITY_ON_MAP_URL, method = { RequestMethod.GET,
                    RequestMethod.POST })
    public @ResponseBody List<Lead> searchByCityOnMap(@RequestParam(required = false) Integer cityId,
                    HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        ReInvestor reInvestor = (ReInvestor) httpSession.getAttribute("investor");
        List<Lead> leadListBycity = leadService.getAllLeadsListByCityName(reInvestor.getId(), cityId);
        for (Lead lead : leadListBycity) {
            lead.getBirddog().setReInvestor(null);
        }
        return leadListBycity;
    }

}
