package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.UploadPdf;

public interface SuperAdminUploadPdfRepository extends JpaRepository<UploadPdf, Integer>{

	List<UploadPdf> findByRoleIdAndTypeAndIsDeletedAndFileType(Integer roleId, String type, int zero, String fileType);


}
