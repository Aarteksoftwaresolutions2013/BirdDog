package com.birddog.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.commonutility.FindLatitudeAndLongitude;
import com.birddog.model.Address;
import com.birddog.model.City;
import com.birddog.model.Comment;
import com.birddog.model.Lead;
import com.birddog.model.UserRole;
import com.birddog.repository.AddressRepository;
import com.birddog.repository.CityRepository;
import com.birddog.repository.CommentRepository;
import com.birddog.repository.LeadRepository;
import com.birddog.repository.UserRoleRepository;
import com.birddog.service.LeadService;
import com.birddog.util.DateUtil;
import com.birddog.util.IConstant;
import com.birddog.util.LeadApproval;
import com.birddog.util.LeadStatus;

/**
 * 
 * @author Aartek
 *
 */
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	AddressRepository addressRepository;

	public void save(Lead lead) {
		lead.setCreationTime(DateUtil.todayDate());
		lead.setUpdationTime(DateUtil.todayDate());
		lead.setStatus(LeadStatus.REVIEWING);
		lead.setApproval(LeadApproval.PENDING);
		String latLongs[] = null;
		try {
			City city = cityRepository.findOne(lead.getAddress().getCity().getId());
			latLongs = FindLatitudeAndLongitude.getLatLongPositions(lead.getAddress().getAddress1() + ", "
							+ city.getCityName() + ", " + city.getCounty().getCountyName() + ", "
							+ city.getCounty().getState().getStateName() + " " + lead.getAddress().getZipCode());
			lead.getAddress().setLatitude(latLongs[0]);
			lead.getAddress().setLongitude(latLongs[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		leadRepository.save(lead);
	}

	public List<Lead> getAll() {

		return null;
	}

	public Lead update(int id) {

		return leadRepository.findOne(id);
	}

	public void delete(int id) {
		Lead lead = leadRepository.findById(id, IConstant.ZERO);
		lead.setIsDeleted(IConstant.IS_DELETED);
		if (lead != null) {
			leadRepository.save(lead);

		}
	}

	public List<Lead> findAllLeadsByReiId(Integer reiId) {

		List<Lead> leads = leadRepository.findByBirddogReInvestorIdAndIsDeleted(reiId, IConstant.ZERO);
		for (int i = 0; i < leads.size(); i++) {
			leads.get(i).setApprovalStatusColour(respectiveColor(leads.get(i).getApproval()));
		}
		return leads;
	}

	private String respectiveColor(String approval) {
		String result = null;
		if (approval.equals(LeadApproval.APPROVAL)) {
			result = "1CAF49";
		} else if (approval.equals(LeadApproval.REJECTED)) {
			result = "FF0000";
		} else {
			result = "E8E826";
		}

		return result;
	}

	public Lead saveLeadDetail(Lead lead) {

		lead.setCreationTime(DateUtil.todayDate());
		lead.setUpdationTime(DateUtil.todayDate());
		lead.setStatus(LeadStatus.REVIEWING);
		lead.setApproval(LeadApproval.PENDING);
		String latLongs[] = null;
		try {
			City city = cityRepository.findOne(lead.getAddress().getCity().getId());
			latLongs = FindLatitudeAndLongitude.getLatLongPositions(lead.getAddress().getAddress1() + ", "
							+ city.getCityName() + ", " + city.getCounty().getCountyName() + ", "
							+ city.getCounty().getState().getStateName() + " " + lead.getAddress().getZipCode());
			lead.getAddress().setLatitude(latLongs[0]);
			lead.getAddress().setLongitude(latLongs[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return leadRepository.save(lead);
	}

	public List<Lead> getAllLeadById(Integer id) {
		List<Lead> list = leadRepository.findByBirddogIdAndIsDeleted(id, IConstant.ZERO);
		for (Lead lead : list) {
			lead.getBirddog().setReInvestor(null);
		}
		return list;
	}

	public Lead findOne(Integer leadId) {

		return leadRepository.findOne(leadId);
	}

	public List<Comment> getAllComments(Integer leadId) {

		return commentRepository.findByLeadIdAndIsDeleted(leadId, IConstant.ZERO);
	}

	public UserRole getRoleByRoleId(int id) {

		return userRoleRepository.findOne(id);
	}

	public List<Lead> findAllBetweenDates(String fromDate, String toDate, String search) throws ParseException {
		if (search != null && !search.isEmpty() || (fromDate != null && !fromDate.isEmpty())
						&& (toDate != null && !fromDate.isEmpty())) {
			if (search != null && !search.isEmpty()) {
				List<Lead> leads = leadRepository.findByFirstnameStartingWith(search + "%");
				for (int i = 0; i < leads.size(); i++) {
					leads.get(i).setApprovalStatusColour(respectiveColor(leads.get(i).getApproval()));
				}
				return leads;
			} else {
				Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
				Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
				List<Lead> leads = leadRepository.findByCreationDateBetween(fromdate, todate);
				for (int i = 0; i < leads.size(); i++) {
					leads.get(i).setApprovalStatusColour(respectiveColor(leads.get(i).getApproval()));
				}
				return leads;
			}
		} else {
			return null;
		}
	}

	public void updateLeadStatus(Integer leadId, String status) {
		Lead lead = leadRepository.findOne(leadId);
		lead.setStatus(status);
		leadRepository.save(lead);
	}

	public void updateLeadApproval(Integer leadId, String approval) {
		Lead lead = leadRepository.findOne(leadId);
		lead.setApproval(approval);
		leadRepository.save(lead);
	}

	public List<Lead> findAllLeadById(Integer id) {
		List<Lead> list = leadRepository.findByBirddogIdAndIsDeleted(id, IConstant.ZERO);
		return list;
	}

	public List<Lead> getAllLeadListByBirddog(Integer id) {
		List<Lead> leadList = leadRepository.findByBirddogReInvestorIdAndIsDeleted(id, IConstant.ZERO);
		return leadList;
	}

	public List<Address> getAllLead() {

		return addressRepository.findAll();
	}

	public List<Lead> getAllLeadsListByBirddogName(Integer id, String name) {
		List<Lead> leadList = leadRepository.findByBirddogReInvestorIdAndBirddogNameAndIsDeleted(id, name,
						IConstant.ZERO);
		return leadList;
	}

	public boolean deleteLead(Integer id) {
		Lead lead = leadRepository.findOne(id);
		if (lead != null) {
			lead.setIsDeleted(IConstant.IS_DELETED);
			leadRepository.save(lead);
			return true;
		} else {
			return false;
		}

	}

	public List<Lead> getAllLeadDateWise(String fromDate, String toDate) throws ParseException {
		if ((fromDate != null && !fromDate.isEmpty()) && (toDate != null && !fromDate.isEmpty())) {
			Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
			Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
			List<Lead> lead = leadRepository.findByCreationDateBetween(fromdate, todate);
			if (lead != null) {
				for (Lead leads : lead) {
					leads.getBirddog().setReInvestor(null);
				}
				return lead;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Lead viewSingleLeadDetails(Integer id) {
		Lead lead = leadRepository.findOne(id);
		if (lead != null && !lead.equals("")) {
			lead.getBirddog().setReInvestor(null);
			return lead;
		} else {
			return null;
		}

	}

	public List<Lead> getAllLeadsListByCityName(Integer id, Integer cityId) {
		return leadRepository.findByBirddogReInvestorIdAndAddressCityIdAndIsDeleted(id,cityId, IConstant.ZERO);
	}

}
