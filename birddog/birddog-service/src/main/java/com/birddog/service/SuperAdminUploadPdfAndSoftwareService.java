package com.birddog.service;

import java.util.List;

import com.birddog.model.UploadPdf;

public interface SuperAdminUploadPdfAndSoftwareService {

	UploadPdf savePdf(UploadPdf uploadPdf);
	
	List<UploadPdf> getAllPdf(Integer roleId, String type, String fileType);

	UploadPdf getPdfById(Integer pdfId);

	void getPdf(Integer pdfId);
}
