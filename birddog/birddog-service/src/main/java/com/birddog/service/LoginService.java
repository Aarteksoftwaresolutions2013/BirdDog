package com.birddog.service;

import com.birddog.model.Login;

public interface LoginService {

	Login findByEmailPassword(Login login);

	boolean findByEmailPassword(String email);


}
