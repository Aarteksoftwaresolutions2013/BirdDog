package com.birddog.service;

import com.birddog.model.Birddog;

/**
 * 
 * @author Aartek
 *
 */
public interface BirddogRegistrationService extends Service<Birddog> {

	boolean changeBirddogPassword(String oldPassword, String newPassword, Integer id);

	boolean verifyUserEmailId(String emailId);

}
