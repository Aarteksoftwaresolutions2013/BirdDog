package com.birddog.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.Birddog;
import com.birddog.model.SendMail;
import com.birddog.repository.BirddogRepository;
import com.birddog.service.ReInvestorGroupMailingService;
import com.birddog.util.IConstant;
@Service
public class ReInvestorGroupMailingServiceImpl implements ReInvestorGroupMailingService{

	@Autowired
	private BirddogRepository birddogRepository;
	
	public void save(Birddog object) {
	
	}

	public List<Birddog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Birddog update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Birddog> getAllbirddogById(Integer reiId) {
		
		return birddogRepository.findByReInvestorIdAndIsDeleted(reiId,IConstant.ZERO);
	}

	public void sendMailToGroup(SendMail sendMail) {
		List<String> items = Arrays.asList(sendMail.getToMailId().split("\\s*,\\s*"));
		for (String to : items) {
			com.birddog.util.SendMail.commomMailSend(to, sendMail.getSubject(), sendMail.getBody());
		}
		
	}

	

}
