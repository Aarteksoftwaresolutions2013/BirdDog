package com.birddog.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.Login;
import com.birddog.model.UserRole;
import com.birddog.repository.LoginRepository;
import com.birddog.service.LoginService;
import com.birddog.util.IConstant;
import com.birddog.util.SendMail;

/**
 * Used for login . implements Spring Security's UserDetailsService
 * 
 * @author Aartek
 *
 */
@Service("userDetailsService")
public class LoginServiceImpl implements UserDetailsService, LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		Login login = loginRepository.findByEmailAndIsDeleted(username, IConstant.ZERO);
		List<GrantedAuthority> authorities = buildUserAuthority(login.getUserRole());

		return buildUserForAuthentication(login, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(UserRole userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	private User buildUserForAuthentication(Login login, List<GrantedAuthority> authorities) {

		return new User(login.getEmail(), login.getEncrypted(), true, true, true, true, authorities);
	}

	public Login findByEmailPassword(Login login) {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 Login user = loginRepository.findByEmailAndIsDeleted(login.getEmail(), IConstant.ZERO);
		 if(user!=null && !user.equals("")){
		 boolean match = encoder.matches(login.getPassword(),  user.getEncrypted());
		 if(match==true){
		return loginRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
		 }else{
			 return null;
		 }
		 }else{
			 return null;
		 }
	}

	public boolean findByEmailPassword(String email) {
		Login login = loginRepository.findByEmail(email);
		if (login != null && !login.equals("")) {
			SendMail.forgotPassword(login.getEmail(), login.getPassword(), "user");
			return true;
		} else {
			return false;
		}

	}

}
