package com.birddog.service;

import java.text.ParseException;
import java.util.List;

import com.birddog.model.Address;
import com.birddog.model.Comment;
import com.birddog.model.Lead;
import com.birddog.model.UserRole;

public interface LeadService extends Service<Lead>{

    List<Lead> findAllLeadsByReiId(Integer id);

   	Lead saveLeadDetail(Lead lead);

	List<Lead> getAllLeadById(Integer id);

	Lead findOne(Integer leadId);

	List<Comment> getAllComments(Integer leadId);

	UserRole getRoleByRoleId(int userRoleBirddogId);

	List<Lead> findAllBetweenDates(String fromDate, String toDate, String search) throws ParseException;

	void updateLeadStatus(Integer leadId, String status);
	
	void updateLeadApproval(Integer leadId, String approval);

	List<Lead> findAllLeadById(Integer id);

	List<Address> getAllLead();

	List<Lead> getAllLeadListByBirddog(Integer id);

	List<Lead> getAllLeadsListByBirddogName(Integer id, String name);

	boolean deleteLead(Integer id);

	List<Lead> getAllLeadDateWise(String fromDate, String toDate) throws ParseException;

	Lead viewSingleLeadDetails(Integer id);

	List<Lead> getAllLeadsListByCityName(Integer id, Integer cityId);

}
