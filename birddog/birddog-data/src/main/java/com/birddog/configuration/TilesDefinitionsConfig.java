package com.birddog.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;

import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

/**
 * Tiles configuration for both admin and web part.
 * 
 * @author Aartek
 */
public final class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();

    public Definition getDefinition(String name, org.apache.tiles.request.Request tilesContext) {

        return tilesDefinitions.get(name);
    }

    private static void addDefaultLayoutDef(String name, String body, String header, String footer) {

        Map<String, Attribute> attributes = new HashMap<String, Attribute>();
        attributes.put("header", new Attribute(header));
        attributes.put("body", new Attribute(ConstantURL.JSP_PACKAGE + "" + body + "" + ConstantURL.JSP_EXTANTION));
        attributes.put("footer", new Attribute(footer));
        tilesDefinitions.put(name, new Definition(name, ConstantURL.BASE_TEMPLATE, attributes));

    }

    public static void addDefinitions() {

        addDefaultLayoutDef(IConstant.HOME, IConstant.HOME, ConstantURL.HEADER, ConstantURL.FOOTER);

        // RE Investor Registration
        addDefaultLayoutDef(IConstant.REGISTRATION, IConstant.REGISTRATION, ConstantURL.ADMIN_HEADER,
                        ConstantURL.FOOTER);

        // welcome
        addDefaultLayoutDef(IConstant.SUPER_ADMIN_HOME, IConstant.SUPER_ADMIN_HOME, ConstantURL.ADMIN_HEADER,
                        ConstantURL.FOOTER);

        // birddog Registration
        addDefaultLayoutDef(IConstant.BIRDDOG_REGISTRATION, IConstant.BIRDDOG_REGISTRATION, ConstantURL.HEADER,
                        ConstantURL.FOOTER);

        // birddogHome
        addDefaultLayoutDef(IConstant.BIRDDOG_HOME, IConstant.BIRDDOG_HOME, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // investorHome
        addDefaultLayoutDef(IConstant.INVESTOR_HOME, IConstant.INVESTOR_HOME, ConstantURL.REI_HEADER,
                        ConstantURL.FOOTER);

        // addLead
        addDefaultLayoutDef(IConstant.ADD_LEAD, IConstant.ADD_LEAD, ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);

        // Investor Profile
        addDefaultLayoutDef(IConstant.REI_PROFILE, IConstant.INVESTOR_PROFILE, ConstantURL.REI_HEADER,
                        ConstantURL.FOOTER);

        // SuperAdmin Profile
        addDefaultLayoutDef(IConstant.SUPER_ADMIN_PROFILE, IConstant.SUPER_ADMIN_PROFILE, ConstantURL.ADMIN_HEADER,
                        ConstantURL.FOOTER);

        // Birddog Profile
        addDefaultLayoutDef(IConstant.BIRDDOG_PROFILE, IConstant.BIRDDOG_PROFILE, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // reiList
        addDefaultLayoutDef(IConstant.REI_LIST, IConstant.REI_LIST, ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);

        // viewRei
        addDefaultLayoutDef(IConstant.VIEW_REI, IConstant.VIEW_REI, ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);

        // birddoglist
        addDefaultLayoutDef(IConstant.BIRDDOG_LIST, IConstant.BIRDDOG_LIST, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // viewBirddog
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG, IConstant.VIEW_BIRDDOG, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // leadsList
        addDefaultLayoutDef(IConstant.LEADS_LIST, IConstant.LEADS_LIST, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // birddogLeadsList
        addDefaultLayoutDef(IConstant.BIRDDOG_LEADS_LIST, IConstant.BIRDDOG_LEADS_LIST, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // viewLead
        addDefaultLayoutDef(IConstant.VIEW_LEAD, IConstant.VIEW_LEAD, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // viewBirddogLead
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG_LEAD, IConstant.VIEW_LEAD, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // viewBirddogs
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG_LIST, IConstant.VIEW_BIRDDOG_LIST, ConstantURL.REI_HEADER,
                        ConstantURL.FOOTER);

        // sendMessage
        addDefaultLayoutDef(IConstant.SEND_MESSAGE, IConstant.SEND_MESSAGE, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // message
        addDefaultLayoutDef(IConstant.BIRDDOG_MESSAGE, IConstant.BIRDDOG_MESSAGE, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // view tutorial link
        addDefaultLayoutDef(IConstant.VIEW_TUTORIAL, IConstant.VIEW_TUTORIAL, ConstantURL.ADMIN_HEADER,
                        ConstantURL.FOOTER);

        // upload Tutorial rei
        addDefaultLayoutDef(IConstant.UPLOAD_TUTORIAL_REI, IConstant.UPLOAD_TUTORIAL_REI, ConstantURL.ADMIN_HEADER,
                        ConstantURL.FOOTER);

        // upload Tutorial birddog
        addDefaultLayoutDef(IConstant.UPLOAD_TUTORIAL_BIRDDOG, IConstant.UPLOAD_TUTORIAL_BIRDDOG,
                        ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);

        // upload Tutorial Birddog By Rei
        addDefaultLayoutDef(IConstant.UPLOAD_TUTORIAL_BIRDDOG_BY_REI, IConstant.UPLOAD_TUTORIAL_BIRDDOG_BY_REI,
                        ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // super admin change Password
        addDefaultLayoutDef(IConstant.SUPER_ADMIN_CHANGE_PASSWORD, IConstant.SUPER_ADMIN_CHANGE_PASSWORD,
                        ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);

        // forgot Password
        addDefaultLayoutDef(IConstant.FORGOT_PASSWORD, IConstant.FORGOT_PASSWORD, ConstantURL.HEADER,
                        ConstantURL.FOOTER);

        // Rei change Password
        addDefaultLayoutDef(IConstant.REI_CHANGE_PASSWORD, IConstant.REI_CHANGE_PASSWORD, ConstantURL.REI_HEADER,
                        ConstantURL.FOOTER);

        // birddog change Password
        addDefaultLayoutDef(IConstant.BIRDDOG_CHANGE_PASSWORD, IConstant.BIRDDOG_CHANGE_PASSWORD,
                        ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);

        // show map
        addDefaultLayoutDef(IConstant.SHOW_MAP, IConstant.SHOW_MAP, ConstantURL.REI_HEADER, ConstantURL.FOOTER);
        
        //reiAccountSetting
        addDefaultLayoutDef(IConstant.REI_ACCOUNT_SETTING, IConstant.REI_ACCOUNT_SETTING, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        //viewPaymentPage
        addDefaultLayoutDef(IConstant.VIEW_PAYMENT_PAGE, IConstant.VIEW_PAYMENT_PAGE, ConstantURL.REI_HEADER, ConstantURL.FOOTER);
        
        //viewPaymentPage
        addDefaultLayoutDef("returnPage", "returnPage", ConstantURL.REI_HEADER, ConstantURL.FOOTER);
        
        //viewPaymentPage
        addDefaultLayoutDef("canclePage", "canclePage", ConstantURL.REI_HEADER, ConstantURL.FOOTER);
        
        //viewPaymentPage
        addDefaultLayoutDef("notifyPage", "notifyPage", ConstantURL.REI_HEADER, ConstantURL.FOOTER);
        
        //view pdf
        addDefaultLayoutDef(IConstant.VIEW_PDF, IConstant.VIEW_PDF, ConstantURL.ADMIN_HEADER,
                ConstantURL.FOOTER);
        
        //view software
        addDefaultLayoutDef(IConstant.VIEW_SOFTWARE, IConstant.VIEW_SOFTWARE, ConstantURL.ADMIN_HEADER,
                ConstantURL.FOOTER);
        
        
        // view single Tutorial birddog
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_TUTORIAL_BIRDDOG, IConstant.VIEW_SINGLE_TUTORIAL_REI,
                        ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);

        // view Single Tutorial Birddog By Rei
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_TUTORIAL_BIRDDOG_BY_REI,
                        IConstant.VIEW_SINGLE_TUTORIAL_BIRDDOG_BY_REI, ConstantURL.REI_HEADER, ConstantURL.FOOTER);

        // view single Tutorial rei
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_TUTORIAL_REI, IConstant.VIEW_SINGLE_TUTORIAL_REI,
                        ConstantURL.ADMIN_HEADER, ConstantURL.FOOTER);
     // view Birddog Tutorial By SuperAdmin
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN,
                        IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);

        // view Birddog Tutorial By Investor
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR, IConstant.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR,
                        ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);

        // view Single Birddog Tutorial By Investor
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR,
                        IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR, ConstantURL.BIRDDOG_HEADER,
                        ConstantURL.FOOTER);
     // view ReiTutorial By SuperAdmin
        addDefaultLayoutDef(IConstant.VIEW_REI_TUTORIAL_BY_SUPER_ADMIN, IConstant.VIEW_REI_TUTORIAL_BY_SUPER_ADMIN,
                        ConstantURL.REI_HEADER, ConstantURL.FOOTER);
     // view ReiPdfAndSw By SuperAdmin
        addDefaultLayoutDef(IConstant.VIEW_REI_PDF_AND_SW_BY_SUPER_ADMIN, IConstant.VIEW_REI_PDF_AND_SW_BY_SUPER_ADMIN,
                        ConstantURL.REI_HEADER, ConstantURL.FOOTER);
     // view Birddog Tutorial By SuperAdmin
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN,
                        IConstant.VIEW_BIRDDOG_TUTORIAL_BY_SUPER_ADMIN, ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);
     // view Birddog Tutorial By SuperAdmin
        addDefaultLayoutDef(IConstant.VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN,
                        IConstant.VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN, ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);
       /* //upload pdf
        addDefaultLayoutDef(IConstant.UPLOAD_PDF, IConstant.UPLOAD_PDF, ConstantURL.ADMIN_HEADER,
                ConstantURL.FOOTER);
        
        //upload s/w
        addDefaultLayoutDef(IConstant.UPLOAD_SOFTWARE, IConstant.UPLOAD_SOFTWARE, ConstantURL.ADMIN_HEADER,
                ConstantURL.FOOTER);*/
        // view single Pdf And SW rei
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_BIRDDOG_ATTACHMENT, IConstant.VIEW_SINGLE_BIRDDOG_ATTACHMENT,
                        ConstantURL.BIRDDOG_HEADER, ConstantURL.FOOTER);
        // view single Pdf And SW rei
        addDefaultLayoutDef(IConstant.VIEW_SINGLE_REI_ATTACHMENT, IConstant.VIEW_SINGLE_REI_ATTACHMENT,
                        ConstantURL.REI_HEADER, ConstantURL.FOOTER);
    }

	public static void addUserLayoutDef(String name, String body, String header, String footer)
	{
		addDefaultLayoutDef(name, body, header, footer);		
	}

}