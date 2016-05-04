package com.birddog.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.Address;
import com.birddog.model.Birddog;
import com.birddog.model.Lead;
import com.birddog.model.UploadTutorial;
import com.birddog.repository.AddressRepository;
import com.birddog.repository.BirddogRepository;
import com.birddog.repository.LeadRepository;
import com.birddog.repository.SuperAdminUploadTutorialRepository;
import com.birddog.repository.TutorialRepository;
import com.birddog.service.BirddogService;
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
public class BirddogServiceImpl implements BirddogService {

	@Autowired
	private BirddogRepository birddogRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private SuperAdminUploadTutorialRepository superAdminUploadTutorialRepository;

	public void save(Birddog birddog) {
		if (birddog != null) {
			Address address = addressRepository.save(birddog.getAddress());
			birddog.setAddress(address);
			birddogRepository.updateBirddogProfile(birddog.getId(), birddog.getName(), birddog.getContactNo(), birddog
							.getAddress().getId());
		}
	}

	public List<Birddog> getAll() {

		return null;
	}

	public Birddog update(int id) {

		return null;
	}

	public void delete(int id) {

	}

	public Birddog getLoggedInUserInfo(String userName) {

		Birddog birddog = birddogRepository.findByEmail(userName);

		return birddog;
	}

	public Birddog getBirddogById(Integer birddogId) {

		return birddogRepository.findOne(birddogId);
	}

	public List<Birddog> getAllBirddogs(Integer reiId) {

		List<Birddog> birddogs = birddogRepository.findByReInvestorIdAndIsDeleted(reiId, IConstant.ZERO);
		for (int i = 0; i < birddogs.size(); i++) {
			birddogs.get(i).setSourceQuality(getSourceQuality(birddogs.get(i)));
		
		}
		return birddogs;
	}

	private String getSourceQuality(Birddog birddog) {

		List<Lead> totalLeadsIn30Days = leadRepository.findByBirddogIdAndDateRange(birddog.getId(),
						DateUtil.dateBeforeThirtyDays(), DateUtil.todayDate(),LeadApproval.APPROVAL,LeadStatus.SUCCESS);
		List<Lead> totalLeadsIn60Days = leadRepository.findByBirddogIdAndDateRange(birddog.getId(),
						DateUtil.dateBeforeSixtyDays(), DateUtil.todayDate(),LeadApproval.APPROVAL,LeadStatus.SUCCESS);
		List<Lead> closedLeadsIn30Days = leadRepository.findByBirddogIdAndDateRangeAndStatus(birddog.getId(),
						DateUtil.dateBeforeThirtyDays(), DateUtil.todayDate(), LeadStatus.SUCCESS);
		String result = closedLeadsIn30Days.size() + " Successed out of " + totalLeadsIn30Days.size() + "=";
		if (totalLeadsIn60Days.size() >= 30) {
			int i = closedLeadsIn30Days.size();
			int j = totalLeadsIn30Days.size();
			int r = (i * 100) / j;
			result = result + r;
		} else {
			result = result + "No Bonus";
		}

		return result;
	}

	public Birddog findByEmail(String email) {
		return birddogRepository.findByEmail(email);
	}

	public void saveBirddogImages(String imageName, Integer id) {
		birddogRepository.updateByBirddogId(id, imageName);

	}

	public Birddog findByBirddogId(Integer id) {
		Birddog birddog = birddogRepository.findOne(id);
		birddog.setReInvestor(null);
		return birddog;
	}

	public Birddog updateBirddogProfile(Birddog birddog) {
		Birddog locator = birddogRepository.findOne(birddog.getId());
		birddog.setReInvestor(locator.getReInvestor());
		return birddogRepository.save(birddog);
	}

	public List<Birddog> findAllBetweenDates(String fromDate, String toDate, String txtSearch, Integer reiId)
					throws ParseException {
		if (txtSearch != null && !txtSearch.isEmpty() || (fromDate != null && !fromDate.isEmpty())
						&& (toDate != null && !fromDate.isEmpty())) {
			if (txtSearch != null && !txtSearch.isEmpty()) {
				return birddogRepository.findByReInvestorIdAndFirstnameStartingWith(txtSearch + "%", reiId,
								IConstant.ZERO);
			} else {
				Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
				Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
				return birddogRepository.findByCreationDateBetween(fromdate, todate);
			}
		} else {
			return null;
		}

	}

	public List<UploadTutorial> getAllBirddogTutorials(Integer id, String type) {
		return superAdminUploadTutorialRepository.findByRoleIdAndTypeAndIsDeleted(id, type,IConstant.ZERO);
	}
}
