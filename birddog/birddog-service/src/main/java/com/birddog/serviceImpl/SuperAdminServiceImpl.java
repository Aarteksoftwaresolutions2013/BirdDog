package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.birddog.model.Address;
import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.model.SuperAdmin;
import com.birddog.repository.AddressRepository;
import com.birddog.repository.LoginRepository;
import com.birddog.repository.SuperAdminnRepository;
import com.birddog.service.SuperAdminService;
/**
 * 
 * @author Aartek
 *
 */
@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	
	@Autowired
	private SuperAdminnRepository superAdminnRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private LoginRepository loginRepository;

	public void save(SuperAdmin superAdmin) {
		
		if (superAdmin != null) {
			Address address = addressRepository.save(superAdmin.getAddress());
			superAdmin.setAddress(address);
			superAdminnRepository.updateSuperAdminProfile(superAdmin.getId(), superAdmin.getName(),superAdmin.getContactNo(),superAdmin.getAddress().getId());
		
		}
	}

	public List<SuperAdmin> getAll() {
		return null;
	}

	public SuperAdmin update(int id) {
		return null;
	}

	public void delete(int id) {

	}

	public SuperAdmin getLoggedInUserInfo(String userName) {

		return superAdminnRepository.findByEmail(userName);
	}

	public SuperAdmin getSuperAdminById(Integer superAdminId) {
		return superAdminnRepository.findById(superAdminId);
	}

	public void saveSuperAdminImages(String imageName, Integer id) {
		superAdminnRepository.updateByReInvestorId(id,imageName);
		
	}

	public boolean changeSuperAdminPassword(String oldPassword, String newPassword, Integer id) {
	    SuperAdmin superAdmin = superAdminnRepository.findOne(id);
	    Login login = loginRepository.findByEmail(superAdmin.getEmail());
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
	
}
		
		
		/*PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encriptedPassword = passwordEncoder.encode(oldPassword);
		
		boolean encriptedPassword1 = passwordEncoder.matches(oldPassword, encriptedPassword);*/
		
		
		
		/*Login login1 = loginRepository.findByIdAndPassword(id,encriptedPassword);
		if(login!=null && !login.equals("")){
		login.setNewPassword(newPassword);
		loginRepository.save(login);
		return true;
		}else{
		return false;
		}*/
	

	/*public void saveSuperAdminVideo(String videoName, Integer id) {
		SuperAdmin superAdmin =superAdminnRepository.findOne(id);
		superAdmin.setVideoName(videoName);
		superAdminnRepository.save(superAdmin);
		
	}

	public UploadVideo saveVideoInformation(UploadVideo uploadVideo) {
		return uploadvideoRepository.save(uploadVideo);
		
	}

	public UploadVideo getVideo(Integer videoId) {
		
		return uploadvideoRepository.findOne(videoId);
	
	}

	public List<UploadVideo> getAllVideo(Integer roleId, String type) {
	
		return uploadvideoRepository.findByRoleIdAndType(roleId,type);
	}

	public List<UploadVideo> getAllSuperAdminVideo(Integer roleId, String type) {
		
		return uploadvideoRepository.findByRoleIdAndType(roleId,type);
	}
*/
	
