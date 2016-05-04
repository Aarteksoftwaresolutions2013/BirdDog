package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.Birddog;
import com.birddog.model.Login;
import com.birddog.model.UserRole;
import com.birddog.repository.BirddogRepository;
import com.birddog.repository.LoginRepository;
import com.birddog.repository.ReInvestorRepository;
import com.birddog.service.BirddogRegistrationService;
import com.birddog.util.EncryptDecrypt;
import com.birddog.util.IConstant;

/**
 * 
 * @author Aartek
 *
 */
@Transactional
@Service
public class BirddogRegistrationServiceImpl implements BirddogRegistrationService {

	@Autowired
	private BirddogRepository birddogRepository;

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ReInvestorRepository reInvestorRepository;

	public void save(Birddog birddog) {

		if (birddog != null && birddog.getEmail() != "") {
			Login login = new Login();
			UserRole user = new UserRole();
			user.setUserRoleId(birddog.getBirdId());
			login.setUserRole(user);
			login.setEmail(birddog.getEmail());
			login.setPassword(birddog.getPassword());
			login.setEncrypted(EncryptDecrypt.springSecurityEncription(birddog.getPassword()));
			loginRepository.save(login);
			birddog.setReInvestor(reInvestorRepository.findOne(birddog.getReInvestor().getId()));
			birddogRepository.save(birddog);
		}

	}

	public List<Birddog> getAll() {

		return null;
	}

	public Birddog update(int id) {

		return null;
	}

	public void delete(int id) {
		Birddog birddog = birddogRepository.findOne(id);
		birddog.setIsDeleted(IConstant.IS_DELETED);
		if (birddog != null) {
			birddogRepository.save(birddog);

		}
	}

	public boolean changeBirddogPassword(String oldPassword, String newPassword, Integer id) {
		Birddog birddog = birddogRepository.findOne(id);
	    Login login = loginRepository.findByEmail(birddog.getEmail());
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 boolean match = encoder.matches(oldPassword,  login.getEncrypted());
		 if(match){
		 login.setPassword(newPassword);
		 login.setEncrypted(encoder.encode(newPassword));
		 loginRepository.save(login);
		 return true;
		 }else{
			 return false; 
		 }
	    }

	public boolean verifyUserEmailId(String emailId) {
		Login login = loginRepository.findByEmail(emailId);
		if(login!=null){
			return true;
		}else{
			return false;
		}
	}
}
