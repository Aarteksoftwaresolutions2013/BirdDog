package com.birddog.service;

import com.birddog.model.SuperAdmin;

/**
 * 
 * @author Aartek
 *
 */
public interface SuperAdminService extends Service<SuperAdmin> {

	SuperAdmin getLoggedInUserInfo(String userName);

	SuperAdmin getSuperAdminById(Integer superAdminId);

	void saveSuperAdminImages(String imageName, Integer id);

	boolean changeSuperAdminPassword(String oldPassword, String newPassword, Integer integer);

}
