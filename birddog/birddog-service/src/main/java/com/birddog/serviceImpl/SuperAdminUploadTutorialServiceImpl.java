package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.UploadTutorial;
import com.birddog.repository.SuperAdminUploadTutorialRepository;
import com.birddog.service.SuperAdminUploadTutorialService;
import com.birddog.util.IConstant;

@Service
public class SuperAdminUploadTutorialServiceImpl implements SuperAdminUploadTutorialService {

	@Autowired
	private SuperAdminUploadTutorialRepository superAdminUploadTutorialRepository;
	
	public void save(UploadTutorial object) {
		// TODO Auto-generated method stub
		
	}

	public List<UploadTutorial> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UploadTutorial update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<UploadTutorial> getAllTutorial(Integer roleId, String type) {
		
		return superAdminUploadTutorialRepository.findByRoleIdAndTypeAndIsDeleted(roleId,type,IConstant.ZERO);
	}

	public UploadTutorial saveTutorial(UploadTutorial uploadTutorial) {
		
		return superAdminUploadTutorialRepository.save(uploadTutorial);
	}

	public UploadTutorial getTutorialById(Integer tutorialId) {
		
		return superAdminUploadTutorialRepository.findOne(tutorialId);
	}

	public void getTutorial(Integer tutorialId) {
		UploadTutorial uploadTutorial =superAdminUploadTutorialRepository.findOne(tutorialId);
		if(uploadTutorial!=null){
		uploadTutorial.setIsDeleted(IConstant.IS_DELETED);
		superAdminUploadTutorialRepository.save(uploadTutorial);
		}
		
	}

}
