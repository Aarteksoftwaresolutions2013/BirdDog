package com.birddog.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.birddog.configuration.TilesDefinitionsConfig;
import com.birddog.model.UploadPdf;
import com.birddog.service.SuperAdminUploadPdfAndSoftwareService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;
import com.birddog.util.ImageUtil;

@Controller
public class SuperAdminUploadPdfAndSoftwareController {

	@Autowired
	private SuperAdminUploadPdfAndSoftwareService superAdminUploadPdfService;

	@RequestMapping(value = ConstantURL.PDF_URL, method = { RequestMethod.GET })
	public String viewPdfs() {

		return IConstant.VIEW_PDF;
	}

	@RequestMapping(value = ConstantURL.SOFTWARE_URL, method = { RequestMethod.GET })
	public String viewSoftware() {

		return IConstant.VIEW_SOFTWARE;
	}

	@RequestMapping(value = ConstantURL.UPLOAD_PDF, method = { RequestMethod.GET })
	public String uploadPdf(@ModelAttribute("UploadPdf") UploadPdf uploadPdf,
			ModelMap model, String message,
			@RequestParam(required = false) Integer roleId, String type) {
		List<UploadPdf> pdfAndSWList = superAdminUploadPdfService.getAllPdf(
				roleId, type, IConstant.PDF_FILE);
		model.addAttribute("pdfAndSWList", pdfAndSWList);
		model.addAttribute("message", message);
		model.addAttribute("roleId", roleId);
		model.addAttribute("type", type);
		if(type.equals("default"))
		{
			TilesDefinitionsConfig.addUserLayoutDef(IConstant.UPLOAD_PDF, IConstant.UPLOAD_PDF, ConstantURL.ADMIN_HEADER,
	                ConstantURL.FOOTER);
		}
		else {
			TilesDefinitionsConfig.addUserLayoutDef(IConstant.UPLOAD_PDF, IConstant.UPLOAD_PDF, ConstantURL.REI_HEADER,
	                ConstantURL.FOOTER);
		}
		return IConstant.UPLOAD_PDF;
	}

	@RequestMapping(value = ConstantURL.UPLOAD_SOFTWARE, method = { RequestMethod.GET })
	public String uploadSoftware(
			@ModelAttribute("UploadPdf") UploadPdf uploadPdf, ModelMap model,
			String message, @RequestParam(required = false) Integer roleId,
			String type) {
		List<UploadPdf> pdfAndSWList = superAdminUploadPdfService.getAllPdf(
				roleId, type, IConstant.APP_FILE);
		model.addAttribute("pdfAndSWList", pdfAndSWList);
		model.addAttribute("message", message);
		model.addAttribute("roleId", roleId);
		model.addAttribute("type", type);
		if(type.equals("default"))
		{
			TilesDefinitionsConfig.addUserLayoutDef(IConstant.UPLOAD_SOFTWARE, IConstant.UPLOAD_SOFTWARE, ConstantURL.ADMIN_HEADER,
	                ConstantURL.FOOTER);
		}
		else {
			TilesDefinitionsConfig.addUserLayoutDef(IConstant.UPLOAD_SOFTWARE, IConstant.UPLOAD_SOFTWARE, ConstantURL.REI_HEADER,
	                ConstantURL.FOOTER);
		}
		return IConstant.UPLOAD_SOFTWARE;
	}

	@RequestMapping(value = ConstantURL.SAVE_PDF_AND_SW, method = { RequestMethod.GET,
			RequestMethod.POST })
	private String savePdf(@ModelAttribute("UploadPdf") UploadPdf uploadPdf,
			ModelMap model, @RequestParam("file") MultipartFile file) {

		File file2 = new File(IConstant.PDF_AND_SW_PATH);
		if (!file2.exists()) {
			file2.mkdir();
		}

		String f = file.getOriginalFilename();
		uploadPdf.setName(f);
		if (f != null && f != "" && f.endsWith(".pdf")
				&& uploadPdf.getFileType().equals(IConstant.PDF_FILE)) {
			// uploadPdf.setFileType(IConstant.PDF_FILE);
			UploadPdf pdf = superAdminUploadPdfService.savePdf(uploadPdf);
			ImageUtil.savePdf(file, pdf.getId());
			model.addAttribute("message",
					ConstantMessage.SAVE_PDF_SUCCESS_MESSAGE);
			model.addAttribute("type", pdf.getType());
			model.addAttribute("roleId", pdf.getRoleId());
		} else if (f != null && f != "" && f.endsWith(".exe")
				&& uploadPdf.getFileType().equals(IConstant.APP_FILE)) {
			// uploadPdf.setFileType(IConstant.APP_FILE);
			UploadPdf pdf = superAdminUploadPdfService.savePdf(uploadPdf);
			ImageUtil.savePdf(file, pdf.getId());
			model.addAttribute("message",
					ConstantMessage.SAVE_SOFTWARE_SUCCESS_MESSAGE);
			model.addAttribute("type", pdf.getType());
			model.addAttribute("roleId", pdf.getRoleId());
		} else
			model.addAttribute("message",
					ConstantMessage.SAVE_PDF_SW_FIALURE_MESSAGE);

//		return "redirect:" + ConstantURL.UPLOAD_PDF;
		if (uploadPdf.getFileType().equals(IConstant.APP_FILE)) {
			return "redirect:" + IConstant.UPLOAD_SOFTWARE;
		} else
			return "redirect:" + IConstant.UPLOAD_PDF;
	}

	@RequestMapping(value = ConstantURL.UPDATE_SUPER_ADMIN_PDF_AND_SW_URL, method = {
			RequestMethod.GET, RequestMethod.POST })
	private String updateSuperAdminTutorial(
			@ModelAttribute("UploadPdf") UploadPdf uploadPdf, ModelMap model,
			@RequestParam(required = false) Integer id, Integer roleId,
			String type) {
		UploadPdf pdfAndSW = superAdminUploadPdfService.getPdfById(id);
		List<UploadPdf> pdfAndSWList = superAdminUploadPdfService.getAllPdf(
				roleId, type, uploadPdf.getFileType());
		model.addAttribute("pdfAndSWList", pdfAndSWList);
		model.addAttribute("UploadPdf", pdfAndSW);
		if ( uploadPdf.getFileType().equals(IConstant.APP_FILE)) {
			return IConstant.UPLOAD_SOFTWARE;
		} else
			return IConstant.UPLOAD_PDF;
	}

	@RequestMapping(value = ConstantURL.DELETE_SUPER_ADMIN_PDF_AND_SW_URL, method = {
			RequestMethod.GET, RequestMethod.POST })
	private String deleteSuperAdminTutorial(ModelMap model,
			@RequestParam(required = false) Integer id, Integer roleId,
			String type, String message, String fileType) {

		superAdminUploadPdfService.getPdf(id);
		model.addAttribute("roleId", roleId);
		model.addAttribute("type", type);
		model.addAttribute("message",
				ConstantMessage.DELETE_TUTORIAL_SUCCESS_MESSAGE);
		if (fileType.equals(IConstant.APP_FILE)) {
			return "redirect:" + IConstant.UPLOAD_SOFTWARE;
		} else
			return "redirect:" + IConstant.UPLOAD_PDF;
	}

	@RequestMapping(value = "/downloadAttachment")
	public void downloadAttachment(
			@RequestParam(required = false)Integer id, String fileName,HttpServletRequest request, HttpServletResponse response) {
		fileName=id+"_"+fileName;
		ImageUtil.downloadAttachment(fileName, response);
	}
	
}
