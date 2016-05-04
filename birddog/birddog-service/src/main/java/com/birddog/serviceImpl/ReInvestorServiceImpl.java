package com.birddog.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.model.UserRole;
import com.birddog.repository.LoginRepository;
import com.birddog.repository.ReInvestorRepository;
import com.birddog.service.ReInvestorService;
import com.birddog.util.EncryptDecrypt;
import com.birddog.util.IConstant;
import com.birddog.util.RandomNoGenerate;
import com.birddog.util.SendMail;

/**
 * 
 * @author Aartek
 *
 */
@Transactional
@Service
public class ReInvestorServiceImpl implements ReInvestorService {

    @Autowired
    private ReInvestorRepository registrationRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ReInvestorRepository reInvestorRepository;

    public void save(ReInvestor reInvestor) {

        String random = RandomNoGenerate.generateRandomString();

        if (reInvestor != null && reInvestor.getEmail() != "") {

            Login login = new Login();
            UserRole user = new UserRole();
            user.setUserRoleId(reInvestor.getReiRole());
            login.setUserRole(user);
            login.setEmail(reInvestor.getEmail());
            login.setPassword(random);
            String password = EncryptDecrypt.springSecurityEncription(random);
            login.setEncrypted(password);
            Login userLogin = loginRepository.save(login);
            ReInvestor investor = registrationRepository.save(reInvestor);

            if (investor != null) {

                SendMail.mailSend(investor.getEmail(), investor.getName(), userLogin.getPassword());
            }

        }

    }

    public List<ReInvestor> getAll() {

        return reInvestorRepository.findByIsDeleted(IConstant.ZERO);
    }

    public ReInvestor update(int id) {

        return null;
    }

    public void delete(int id) {
    	ReInvestor reInvestor = reInvestorRepository.findOne(id);
    	reInvestor.setIsDeleted(IConstant.IS_DELETED);
		if (reInvestor != null) {
			reInvestorRepository.save(reInvestor);

		}
    	
    }

    public ReInvestor getLoggedInUserInfo(String userName) {

        return registrationRepository.findByEmail(userName);
    }

    public ReInvestor getInvestorDetails(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

	public List<ReInvestor> findAllBetweenDates(String fromDate, String toDate, String search) throws ParseException {
		if(search != null && !search.isEmpty() || (fromDate!=null &&!fromDate.isEmpty()) && (toDate!=null &&!fromDate.isEmpty())){
		 if (search != null && !search.isEmpty()) {
	            return reInvestorRepository.findByFirstnameStartingWith(search + "%");
	        } else {
	            Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
	            Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
	            return reInvestorRepository.findByCreationDateBetween(fromdate, todate);
	        }
		}else{
    		return null;
    	}
	}

}
