package com.birddog.service;

import com.birddog.model.AccountSettings;
import com.birddog.model.Address;
import com.birddog.model.ReInvestor;

public interface ReInvestorProfileService extends Service<ReInvestor> {

	public ReInvestor getReiById(Integer id);

	public void saveAddress(Address address);

	public void saveImages(String imageName, Integer id);

	public boolean changeReInvestorPassword(String oldPassword, String newPassword, Integer id);

    public AccountSettings getAccountSettings(Integer id);

    public void saveAccountSettings(AccountSettings accountSettings);



}
