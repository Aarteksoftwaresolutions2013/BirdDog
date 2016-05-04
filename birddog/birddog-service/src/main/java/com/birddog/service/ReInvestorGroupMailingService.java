package com.birddog.service;

import java.util.List;

import com.birddog.model.Birddog;
import com.birddog.model.SendMail;

public interface ReInvestorGroupMailingService extends Service<Birddog> {

	List<Birddog> getAllbirddogById(Integer reiId);

	void sendMailToGroup(SendMail sendMail);

	

}
