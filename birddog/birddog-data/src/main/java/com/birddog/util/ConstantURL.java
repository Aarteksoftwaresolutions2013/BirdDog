package com.birddog.util;

import org.apache.tiles.Attribute;

public class ConstantURL {

    // URL Prefix
    public static final String INVESTOR_URL = "http://rentmanager.princeglobalconsultants.com/birddog-web/birddogRegistration?REI=";
   // public static final String INVESTOR_URL = "http://103.9.15.59:8081/birddog-web/birddogRegistration?REI=";
    public static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/layout/defaultLayout.jsp");

    // System Path
    public static final String RESOURCE_HANDLER = "/resources/**";
    public static final String RESOURCE_LOCATION = "/resources/";
    
    //layout component
    public static final String JSP_PACKAGE = "/WEB-INF/jsp/";
    public static final String HEADER = "/WEB-INF/layout/header.jsp";
    public static final String FOOTER = "/WEB-INF/layout/footer.jsp";
    public static final String ADMIN_HEADER = "/WEB-INF/layout/adminHeader.jsp";
    public static final String REI_HEADER = "/WEB-INF/layout/reiHeader.jsp";
    public static final String BIRDDOG_HEADER = "/WEB-INF/layout/birddogHeader.jsp";
    public static final String JSP_EXTANTION = ".jsp";
    
    // Action URL
    public static final String REGISTRATION_URL = "/registration";
    public static final String HOME_URL = "/home";
    public static final String SAVE_REGISTRATION_URL = "/saveRegistration";
    public static final String BIRDDOG_REGISTRATION_URL = "/birddogRegistration";
    public static final String SAVE_BIRDDOG_REGISTRATION_URL = "/saveBirddogRegistration";
    public static final String LOGIN_URL = "/login";
    public static final String WELCOME_URL_PATTERN = "/welcome/**";
    public static final String LOGIN_FAILIOUR = "/login?error";
    public static final String WELCOME_URL = "/welcome";
    public static final String LOGOUT_URL = "/login?logout";
    public static final String ERROR_URL = "/error";
    public static final String ADD_LEAD_URL = "/addLead";
    public static final String SAVE_LEAD_URL = "/saveLead";
    public static final String STATE_BY_COUNTRY_ID_URL = "/stateByCountryId";
    public static final String CITY_BY_STATE_ID_URL = "/cityByStateId";
    public static final String CANCEL_URL = "/cancel";
    public static final String VIEW_REI_LIST_URL = "/viewReiList";
    public static final String VIEW_REI_URL = "/viewRei";
    public static final String GROUP_MAIL_TO_BIRDDOG_URL = "/groupMailToBirddog";
    public static final String SEND_MAIL_TO_BIRDDOG_URL = "/sendMailToBirddog";
    public static final String GROUP_MAIL_TO_BIRDDOG = "groupMailToBirddog";
    public static final String DELETE_BIRDDOG_URL = "/deleteBirddog";
    public static final String DELETE_LEAD_URL = "/deleteLead";
    public static final String SEARCH_BY_DATE_URL = "/searchByDate";
 
    // multipartResolver
    
    public static final String BIRDDOG_PROFILE_URL = "/birddogProfile";
    public static final String SAVE_BIRDDOG_PROFILE_URL = "/saveBirddogProfile";
    public static final String VIEW_BIRDDOGS_URL = "/viewBirddogs";
    public static final String VIEW_BIRDDOG_URL = "/viewBirddog";
    public static final String VIEW_LEADS_URL = "viewLeads";
    public static final String VIEW_LEAD_URL = "/viewLead";
    public static final String SEARCH_BIRDDOG_BY_REI_URL = "/searchBirddogByRei";
    public static final String SEARCH_LEAD_BY_REI_URL = "/searchLeadByRei";
    public static final String SEARCH_LEAD_BY_BIRDDOG_DATE_URL = "/searchLeadByBirddogDate";
    public static final String DELETE_INVESTOR_URL = "/deleteInvestor";
    public static final String STATE_URL = "/getAllState";
    public static final String GET_COUNTY_BY_STATE_URL = "/getCountyByState";
    public static final String GET_CITY_BY_COUNTY_URL = "/getCityByCounty";
    public static final String UPDATE_BIRDDOG_LEAD_URL = "/updateBirddogLead";
    public static final String ADD_COMMENT_URL = "/addComment";
    public static final String SHOW_ACCOUNT_SETTING_URL="/showAccountSetting";
    public static final String SEND_PAYMENT_URL="/sendPayment";
    
    // webservice Action URL
    public static final String BIRDDOG_LOGIN_URL = "/getBirddogLoginDetail";
    public static final String LEAD_URL = "/getAllLead";
    public static final String SAVE_WS_LEAD_URL = "/saveLeadDetails";
    public static final String CITY_BY_COUNTY_ID_URL = "/cityByCountyId";
    public static final String COUNTY_BY_STATE_ID_URL = "/countyByStateId";
    public static final String VIEW_BIRDDOG_LEADS_URL = "/viewBirddogLeads";
    public static final String VIEW_BIRDDOG_LEAD_URL = "/viewBirddogLead";
    public static final String BIRDDOG_PROFILE_WS_URL = "/viewBirddogProfile";
    public static final String UPDATE_BIRDDOG_PROFILE_WS_URL = "/updateBirddogProfile";
    public static final String BIRDDOG_WS_CHANGE_PASSWORD = "/ChangePassword";
    public static final String BIRDDOG_FORGOT_PASSWORD_WS = "/birddogForgotPasswordWs";
    public static final String WS_LOGIN_URL = "/getBirddogLoginDetail";
	public static final String BIRDDOG_ADDCOMMENT_WS_URL = "/birddogAddCommentWS";
    public static final String GET_ALL_COMMENT_WS_URL = "/getAllCommentWs";
    public static final String GET_MESSAGE_WS_URL = "/getAllMessage";
    public static final String VIEW_ALL_BIRDDOG_TUTORIAL_WS = "/viewAllBirddogTutorialWs";
    public static final String VIEW_SINGLE_LEAD_WS = "/viewSingleLeadWs";
    public static final String VIEW_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS = "/viewSuperAdminTutorialForBirddogWs";
    public static final String VIEW_SINGLE_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS = "/viewSingleSuperAdminTutorialForBirddogWs";

    
    
    
    
    
   public static final String SEND_MESSAGE_URL = "/sendMessage";
    public static final String MESSAGE_URL = "/message";
    public static final String SAVE_MESSAGE_URL = "/saveMessage";
    public static final String MESSAGES_URL = "/messages";


    public static final String SEARCH_REI_CREATION_DATE_BY_ADMIN_URL = "/searchReiCreationDateByAdmin";

    public static final String SUPER_ADMIN_CHANGE_PASSWORD_URL = "/superAdminChangePassword";
    public static final String SHOW_ADMIN_CHANGE_PASSWORD_PAGE_URL = "/showAdminChangePassword";
    public static final String SHOW_FORGOT_PASSWORD_PAGE_URL = "/showForgotPasswordPage";
    public static final String FORGOT_PASSWORD = "/forgotPassword";
    public static final String SHOW_REI_CHANGE_PASSWORD_PAGE_URL = "/showReiChangePasswordPage";
    public static final String REI_CHANGE_PASSWORD_URL = "/reiChangePassword";
    public static final String SHOW_BIRDDOG_CHANGE_PASSWORD_PAGE_URL = "/showBirddogChangePassword";
    public static final String BIRDDOG_CHANGE_PASSWORD_URL = "/birddogChangePassword";
	public static final String UPDATE_LEAD_DETAIL_WS = "/updateLeadWS";
	public static final String BIRDDOG_GET_COMMENT_WS_URL = "/getALLCommentWS";
	public static final String VERIFY_USER_EMAILID = "/verifyUserEmailId";
	public static final String DELETE_LEAD_DETAIL_WS = "/deleteLeadDetailWS";
	public static final String SEARCH_LEAD_DATE_WISE_WS = "/serchLeadDateWise";
	
	
    public static final String SHOW_MAP_URL = "/showMapPage";
    
    public static final String UPLOAD_TUTORIAL_BIRDDOG_BY_REI_URL = "/uploadTutorialBirddogByRei";
    public static final String UPLOAD_SUPER_ADMIN_VIEDO_URL = "/uploadSuperAdminVideo";
    public static final String VIEW_VIDEO_URL = "/viewVideo";
    public static final String TUTORIALS_URL = "/tutorial";
    public static final String PDF_URL = "/pdf";
    public static final String SOFTWARE_URL = "/software";
    public static final String REI_TUTORIAL_URL = "/reiTutorial";
    public static final String VIEW_SUPER_ADMIN_TUTORIAL_URL = "/viewSuperAdminTutorial";
    public static final String VIDEO_FOR_REI_URL = "/viewVideoRei";
    public static final String VIDEO_FOR_BIRDDOG_URL = "/viewVideoBirddog";
    public static final String VIEW_SUPER_ADMIN_TUTORIAL_BIRDDOG_URL = "/viewTutorialBirddog";
    public static final String SAVEVIDEO_URL = "/savevideo";
    public static final String SAVE_TUTORIAL_BIRDDOG_BY_REI_URL = "/saveTutorialBirddogByRei";
    public static final String UPDATE_TUTORIAL_BIRDDOG_BY_REI_URL = "/updateTutorialBirddogByRei";
    public static final String DELETE_TUTORIAL_BIRDDOG_BY_REI_URL = "/deleteTutorialBirddogByRei";
    public static final String VIEW_SINGLE_TUTORIAL_BIRDDOG_BY_REI_URL = "/viewSingleTutorialBirddogByRei";
    public static final String VIEW_REI_TUTORIAL_BY_SUPER_ADMIN_URL = "/viewReiTutorialBySuperAdmin";
    public static final String VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN_URL = "/viewBirddogTutorialBySuperAdmin";
    public static final String VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN_URL = "/viewSingleBirddogTutorialByAdmin";
    public static final String VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR_URL = "/viewBirddogTutorialByInvestor";
    public static final String VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR_URL = "/viewSingleBirddogTutorialByInvestor";
    public static final String UPLOAD_TUTORIAL_REI_URL = "/uploadTutorialRei";

    public static final String UPLOAD_PDF = "/uploadPdf";
    public static final String UPLOAD_SOFTWARE = "/uploadSoftware";
    
    public static final String SAVE_TUTORIAL_REI_URL = "/saveTutorialRei";
    public static final String SAVE_PDF = "/savePdf";
    public static final String SAVE_SOFTWARE = "/saveSoftware";
    public static final String UPDATE_SUPER_ADMIN_TUTORIAL_REI_URL = "/updateSuperAdminTutorialRei";
    public static final String UPDATE_SUPER_ADMIN_PDF_AND_SW_URL = "/updateSuperAdminPdfAndSW";
    public static final String DELETE_SUPER_ADMIN_TUTORIAL_REI_URL = "/deleteSuperAdminTutorialRei";
    public static final String DELETE_SUPER_ADMIN_PDF_AND_SW_URL = "/deleteSuperAdminPdfAndSW";
    public static final String VIEW_SINGLE_TUTORIAL_REI_URL = "/viewSingleTutorialRei";
    public static final String VIEW_SINGLE_PDF_AND_SW_URL = "/viewSinglePdfAndSW";
    public static final String UPLOAD_TUTORIAL_BIRDDOG_URL = "/uploadTutorialBirddog";
    public static final String SAVE_TUTORIAL_BIRDDOG_URL = "/saveTutorialBirddog";
    public static final String UPDATE_SUPER_ADMIN_TUTORIAL_BIRDDOG_URL = "/updateSuperAdminTutorialBirddog";
    public static final String DELETE_SUPER_ADMIN_TUTORIAL_BIRDDOG_URL = "/deleteSuperAdminTutorialBirddog";
    public static final String VIEW_SINGLE_TUTORIAL_BIRDDOG_URL = "/viewSingleTutorialBirddog";
    public static final String SEARCH_BY_BIRDDOG_ON_MAP_URL = "/searchByBirddogOnMap";
    public static final String SEARCH_BY_CITY_ON_MAP_URL = "/searchByCityOnMap";

    public static final String VIEW_SINGLE_ATTACHMENT_URL = "/viewSinglePdfAndSW";

    public static final String VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN_URL = "/viewBirddogPdfAndSWBySuperAdmin";

    public static final String SAVE_PDF_AND_SW = "/savePdf";
}
