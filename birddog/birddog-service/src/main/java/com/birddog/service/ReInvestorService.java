package com.birddog.service;

import java.text.ParseException;
import java.util.List;

import com.birddog.model.ReInvestor;

/**
 * 
 * @author Aartek
 *
 */
public interface ReInvestorService extends Service<ReInvestor> {

	ReInvestor getLoggedInUserInfo(String userName);

	ReInvestor getInvestorDetails(Integer id);

	List<ReInvestor> findAllBetweenDates(String fromDate, String toDate, String search) throws ParseException;


}
