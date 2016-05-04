package com.birddog.util;

/**
 * Hold all Static elements used in project
 * 
 * @author Aartek
 *
 */
public class IConstant {

    public static final int IS_DELETED = 1;

    // Mail Credentials
    public static final String FROM_EMAIL_ID = "meenalpathre01@princeglobalconsultants.com";
    public static final String FROM_PASSWORD = "U@z]7ZP,$v2B";
    public static final String SMTP_HOST = "mail.princeglobalconsultants.com";
    public static final String SMTP_AUTH = "true";
    public static final String SMTP_PORT = "25";
    public static final String SMTP_SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";

    public static final String PROP_SMTP_HOST = "mail.smtp.host";
    public static final String PROP_SMTP_AUTH = "mail.smtp.auth";
    public static final String PROP_SMTP_PORT = "mail.smtp.port";
    public static final String PROP_SMTP_SOCKET_FACTORY = "mail.smtp.socketFactory.class";
    
    // System
    public static final int MULTIPART_MAX_UPLOAD_SIZE = 104857600;/* 20971520 */
    public static final int MULTIPART_MAX_IN_MEMORY_SIZE = 104857600;
    
//    paths to files
    public static final String BIRDDOG_IMAGES = "E:/Aartek Project/BirdDogs/bird_images/";
    public static final String REINVESTOR_IMAGES = "E:/Aartek Project/BirdDogs/rei_images/";
    public static final String BIRDDOG_PROFILE_IMAGES = "E:/Aartek Project/BirdDogs/bird_profile_images/";
    public static final String SUPER_ADMIN_IMAGES = "E:/Aartek Project/BirdDogs/super_admin_images/";
    public static final String SUPER_ADMIN_VIDEO = "E:/Aartek Project/BirdDogs/super_admin_video/";

    public static final String PDF_AND_SW_PATH = "E:/Aartek Project/BirdDogs/bird_pdf/";
//    public static final String BIRDDOG_IMAGES = "/home/grrajain/jvm/apache-tomcat-7.0.47/domains/rentmanager.princeglobalconsultants.com/birddogUploads/bird_images/";
//    public static final String REINVESTOR_IMAGES = "/home/grrajain/jvm/apache-tomcat-7.0.47/domains/rentmanager.princeglobalconsultants.com/birddogUploads/rei_images/";
//    public static final String BIRDDOG_PROFILE_IMAGES = "/home/grrajain/jvm/apache-tomcat-7.0.47/domains/rentmanager.princeglobalconsultants.com/birddogUploads/bird_profile_images/";
//    public static final String SUPER_ADMIN_IMAGES = "/home/grrajain/jvm/apache-tomcat-7.0.47/domains/rentmanager.princeglobalconsultants.com/birddogUploads/super_admin_images/";
//    public static final String SUPER_ADMIN_VIDEO = "/home/grrajain/jvm/apache-tomcat-7.0.47/domains/rentmanager.princeglobalconsultants.com/birddogUploads/super_admin_video/";
    
    // User Roles
    public static final String USER_ROLE_RE_INVESTOR = "REI";
    public static final String USER_ROLE_SUPER_ADMIN = "SA";
    public static final String USER_ROLE_BIRDDOG = "BIRDDOG";
    public static final String USER_ROLE_AMONYMOUSE = "anonymousUser";
    
    // User Role's Id
    public static final int USER_ROLE_RE_INVESTOR_ID = 1;
    public static final int USER_ROLE_SUPER_ADMIN_ID = 3;
    public static final int USER_ROLE_BIRDDOG_ID = 2;
    
    public static final String MULTIPART_RESOLVER = "multipartResolver";
    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    public static final String JPA_REPOSITORY = "com.birddog.repository";
    public static final String HIBERNATE_PROPERTY_SOURCE = "classpath:hibernate.properties";
    public static final String HIBERNATE_COMPONENT_SCAN = "com.birddog.configuration";
    public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    // key to display message on jsp
    public static final String MESSAGE = "message";

    public static final int INT_ONE = 1;
    
    
    


    public static final String DRIVER_CLASS_NAME = "jdbc.driverClassName";
    public static final String DB_URL = "jdbc.url";
    public static final String DB_USER = "jdbc.username";
    public static final String DB_PASSWORD = "jdbc.password";

    public static final String HIBERNATE_DILECT = "hibernate.dialect";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

    public static final String BASE_PACKAGE = "com.birddog";
    public static final String PROPERTY_SOURCE = "classpath:log4j.properties";

    public static final String USER_DETAIL_SERVICE = "userDetailsService";

    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    public static final String HOME = "home";
    public static final String ERROR = "error";
    public static final String LOGOUT = "logout";
    public static final String BIRDDOG = "birddog";
    public static final String INVESTOR = "investor";
    public static final String SUPER_ADMIN = "superAdmin";
    public static final String INVESTOR_ID = "investorId";
    public static final String REI_ID = "reiId";
    public static final String REGISTRATION = "registration";
    public static final String SUPER_ADMIN_HOME = "superAdminHome";
    public static final String BIRDDOG_REGISTRATION = "birddogRegistration";
    public static final String BIRDDOG_HOME = "birddogHome";
    public static final String INVESTOR_HOME = "investorHome";
    public static final String ADD_LEAD = "addLead";
    public static final String COUNTRIES = "countries";
    public static final String REI_PROFILE = "reiProfile";
    public static final String INVESTOR_PROFILE = "updateReiProfile";
    public static final String SUPER_ADMIN_PROFILE = "updateSuperAdminProfile";
    public static final String BIRDDOG_PROFILE = "updateBirddogProfile";
    public static final String REI_LIST = "reiList";
    public static final String VIEW_REI = "viewRei";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String BIRDDOGS = "birddogs";
    public static final String BIRDDOG_LIST = "birddoglist";
    public static final String SERACH_BIRDDOG_LIST = "searchBirddogList";
    public static final String VIEW_BIRDDOG = "viewBirddog";
    public static final String LEADS = "leads";
    public static final String LEADS_LIST = "leadsList";
    public static final String SEARCH_LEADS = "searchLeads";
    public static final int ZERO = 0;

    public static final String LEAD_SUCCESS = "Save lead successful";
    public static final String OPEN = "OPEN";

    /* It is used for web service */
    public static final String RESPONSE = "response";
    public static final String DATA = "DATA";
    public static final String WS_MESSAGE = "MESSAGE";
    public static final String RESPONSE_SUCCESS_MESSAGE = "200";
    public static final String RESPONSE_NO_DATA_MESSAGE = "400";
    public static final String BIRDDOG_ID = "BirddogId";
    public static final String BIRDDOG_URL = "https://www.youtube.com/embed/";

    public static final String LEAD = "lead";
    public static final String IMAGES = "images";

    public static final String VIEW_LEAD = "viewLead";
    public static final String BIRDDOG_LEADS_LIST = "birddogLeadsList";
    public static final String VIEW_BIRDDOG_LEAD = "viewBirddogLead";
    public static final String VIEW_BIRDDOG_LIST = "groupMailToBirddog";
    public static final String COMMENTS = "comments";
    public static final String COMMENT = "comment";
    public static final String LEAD_ID = "leadId";
    public static final String SEND_MESSAGE = "sendMessage";
    public static final String BIRDDOG_MESSAGE = "birddogMessage";

    public static final String MESSAGE_LIST = "messageList";

    public static final String VIDEO_LIST = "video";
    public static final String VIEW_VIDEO = "viewVideo";

    public static final String VIEW_SUPER_ADMIN_TUTORIAL = "viewSuperAdminTutorial";
    public static final String VIDEO_FOR_REI = "viewVideoRei";
    public static final String VIDEO_FOR_BIRDDOG = "viewVideoBirddog";
    public static final String VIEW_SUPER_ADMIN_TUTORIAL_BIRDDOG = "viewTutorialBirddog";
    public static final String BIRDDOG_LEADS = "birddogLeads";
    public static final String SOURCE_QUALITY = "sourceQuality";
    
    
    

    public static final String VIEW_TUTORIAL = "viewTutorial";
    public static final String VIEW_PDF = "viewPdf";
    public static final String VIEW_SOFTWARE = "viewSoftware";
    public static final String UPLOAD_TUTORIAL_REI = "uploadTutorialRei";
    public static final String UPLOAD_PDF = "uploadPdf";
    public static final String UPLOAD_SOFTWARE = "uploadSoftware";
    public static final String VIEW_SINGLE_TUTORIAL_REI = "viewSingleTutorialRei";
    public static final String VIEW_SINGLE_PDF_AND_SW = "viewSinglePdfAndSW";
    public static final String UPLOAD_TUTORIAL_BIRDDOG = "uploadTutorialBirddog";
    public static final String VIEW_SINGLE_TUTORIAL_BIRDDOG = "viewSingleTutorialBirddog";

    public static final String PDF_FILE = "pdf";
    public static final String APP_FILE = "application";

    public static final String UPLOAD_TUTORIAL_BIRDDOG_BY_REI = "uploadTutorialBirddogByRei";
    public static final String VIEW_SINGLE_TUTORIAL_BIRDDOG_BY_REI = "viewSingleTutorialBirddogByRei";
    public static final String VIEW_REI_TUTORIAL_BY_SUPER_ADMIN = "viewReiTutorialBySuperAdmin";

    public static final String VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN = "viewBirddogTutorialBySuperAdmin";
    public static final String VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN = "viewSingleBirddogTutorialByAdmin";

    public static final String VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR = "viewBirddogTutorialByInvestor";
    public static final String VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR = "viewSingleBirddogTutorialByInvestor";

    public static final String SUPER_ADMIN_CHANGE_PASSWORD = "superAdminChangePassword";
    public static final String FORGOT_PASSWORD = "forgotPassword";

    public static final String REI_CHANGE_PASSWORD = "reiChangePassword";
    public static final String BIRDDOG_CHANGE_PASSWORD = "birddogChangePassword";
    
    public static final String RECORD_NOT_FOUND = "records";
    public static final String REI_ACCOUNT_SETTING = "reiAccountSetting";
    
    public static final String PAY = "pay";
    
    
    public static final String VIEW_PAYMENT_PAGE = "viewPayment";
    
    
    public static final String SHOW_MAP = "showMap";

    public static final String JPG = "jpg";

    public static final String FAILED = "You failed to upload";

    public static final String EMPTY_FILE = "Unable to upload. File is empty.";

    public static final String TEXT_HTML = "text/html";
    public static final String VIEW_REI_PDF_AND_SW_BY_SUPER_ADMIN = "viewReiPdfAndSWBySuperAdmin";

	public static final String VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN = "viewBirddogPdfAndSWBySuperAdmin";

    public static final String VIEW_SINGLE_BIRDDOG_ATTACHMENT = "viewSingleBirddogPdfAndSW";

    public static final String VIEW_SINGLE_REI_ATTACHMENT = "viewSingleReiPdfAndSW";
}
