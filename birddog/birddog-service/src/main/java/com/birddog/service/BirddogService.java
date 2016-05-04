package com.birddog.service;

import java.text.ParseException;
import java.util.List;

import com.birddog.model.Birddog;
import com.birddog.model.UploadTutorial;

/**
 * 
 * @author Aartek
 *
 */
public interface BirddogService extends Service<Birddog> {

	Birddog getLoggedInUserInfo(String userName);

	Birddog getBirddogById(Integer birddogId);

    List<Birddog> getAllBirddogs(Integer id);
    
    Birddog findByEmail(String email);

	void saveBirddogImages(String imageName, Integer id);

	Birddog findByBirddogId(Integer id);

	Birddog updateBirddogProfile(Birddog birddog);

	List<Birddog> findAllBetweenDates(String fromDate, String toDate, String txtSearch, Integer integer) throws ParseException;

	List<UploadTutorial> getAllBirddogTutorials(Integer id, String type);

}
