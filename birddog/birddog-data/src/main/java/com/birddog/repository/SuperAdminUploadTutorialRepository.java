package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.UploadTutorial;

public interface SuperAdminUploadTutorialRepository extends JpaRepository<UploadTutorial, Integer>{

	List<UploadTutorial> findByRoleIdAndTypeAndIsDeleted(Integer roleId, String type, int zero);


}
