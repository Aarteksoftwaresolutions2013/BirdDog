package com.birddog.service;

import java.util.List;

import com.birddog.model.UploadTutorial;

public interface SuperAdminUploadTutorialService extends Service<UploadTutorial>{

	List<UploadTutorial> getAllTutorial(Integer roleId, String type);

	UploadTutorial saveTutorial(UploadTutorial uploadTutorial);

	UploadTutorial getTutorialById(Integer tutorialId);

	void getTutorial(Integer tutorialId);

}
