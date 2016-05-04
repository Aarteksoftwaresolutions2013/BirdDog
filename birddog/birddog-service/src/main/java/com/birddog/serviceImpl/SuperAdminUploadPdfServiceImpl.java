package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.UploadPdf;
import com.birddog.model.UploadTutorial;
import com.birddog.repository.SuperAdminUploadPdfRepository;
import com.birddog.service.SuperAdminUploadPdfAndSoftwareService;
import com.birddog.util.IConstant;

@Service
public class SuperAdminUploadPdfServiceImpl implements
		SuperAdminUploadPdfAndSoftwareService {

	@Autowired
	private SuperAdminUploadPdfRepository superAdminUploadPdfRepository;

	public List<UploadPdf> getAllPdf(Integer roleId, String type,
			String fileType) {

		return superAdminUploadPdfRepository
				.findByRoleIdAndTypeAndIsDeletedAndFileType(roleId, type,
						IConstant.ZERO, fileType);
	}

	public UploadPdf savePdf(UploadPdf uploadPdf) {

		return superAdminUploadPdfRepository.save(uploadPdf);
	}

	public UploadPdf getPdfById(Integer pdfId) {

		return superAdminUploadPdfRepository.findOne(pdfId);
	}

	public void getPdf(Integer pdfId) {

		UploadPdf uploadPdf = superAdminUploadPdfRepository.findOne(pdfId);
		if (uploadPdf != null) {
			uploadPdf.setIsDeleted(IConstant.IS_DELETED);
			superAdminUploadPdfRepository.save(uploadPdf);
		}

	}

}
