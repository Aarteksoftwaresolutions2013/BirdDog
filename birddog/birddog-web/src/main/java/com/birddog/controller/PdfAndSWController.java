package com.birddog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birddog.model.UploadPdf;
import com.birddog.service.SuperAdminUploadPdfAndSoftwareService;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class PdfAndSWController {

	@Autowired
	private SuperAdminUploadPdfAndSoftwareService superAdminUploadPdfAndSWService;

	
	@RequestMapping(value = ConstantURL.VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN_URL, method = { RequestMethod.GET })
	public String viewReiTutorialBySuperAdmin(ModelMap model,@RequestParam(required = false) Integer roleId, String type, String fileType, String message) {
		List<UploadPdf> pdfAndSWList = superAdminUploadPdfAndSWService.getAllPdf(roleId, type, fileType);
		model.addAttribute("list", pdfAndSWList);
		model.addAttribute("fileType", fileType);
		model.addAttribute("message", message);
		if(roleId.equals(1))
		{
			return IConstant.VIEW_REI_PDF_AND_SW_BY_SUPER_ADMIN;
		}
		else{
			return IConstant.VIEW_BIRDDOG_PDF_AND_SW_BY_SUPER_ADMIN;
		}
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_ATTACHMENT_URL, method = {
			RequestMethod.GET, RequestMethod.POST })
	private String viewSingleTutorialRei(ModelMap model,
			@RequestParam(required = false) Integer id, String message) {
		UploadPdf pdfAndSW = superAdminUploadPdfAndSWService.getPdfById(id);
		model.addAttribute("attachment", pdfAndSW);
		model.addAttribute("fileType", pdfAndSW.getFileType());
		model.addAttribute("message", message);
		if(pdfAndSW.getRoleId()==1)
		{
			return IConstant.VIEW_SINGLE_REI_ATTACHMENT;
		}
		return IConstant.VIEW_SINGLE_BIRDDOG_ATTACHMENT;
	}
	
	/*@RequestMapping(value = ConstantURL.VIEW_SINGLE_PDF_AND_SW_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewSingleTutorialRei( ModelMap model,@RequestParam(required = false) Integer id,Integer roleId,String type,String message) {
		UploadPdf pdfAndSW = superAdminUploadPdfAndSWService.getPdfById(id);
		model.addAttribute("tutorial",pdfAndSW);
		return IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_ADMIN;
	}*/
	

	/*@RequestMapping(value = ConstantURL.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR_URL, method = { RequestMethod.GET })
	public String viewBirddogTutorialByInvestor(ModelMap model,@RequestParam(required = false) Integer roleId, String type, String fileType) {
		List<UploadPdf> pdfAndSWList = superAdminUploadPdfAndSWService.getAllPdf(roleId, type, fileType);
		model.addAttribute("tutorialList", pdfAndSWList);
		return IConstant.VIEW_BIRDDOG_TUTORIAL_BY_INVESTOR;
	}
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR_URL, method = { RequestMethod.GET, RequestMethod.POST })
	private String viewSingleBirddogTutorialByInvestor( ModelMap model,@RequestParam(required = false) Integer pdfId,Integer roleId,String type,String message) {
		UploadPdf pdfAndSW = superAdminUploadPdfAndSWService.getPdfById(pdfId);
		model.addAttribute("tutorial",pdfAndSW);
		return IConstant.VIEW_SINGLE_BIRDDOG_TUTORIAL_BY_INVESTOR;
	}*/
	
}
