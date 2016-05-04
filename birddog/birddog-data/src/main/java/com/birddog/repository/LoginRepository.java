package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Login;

/**
 * 
 * 
 * @author Aartek
 *
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findByEmail(String username);

    Login findByEmailAndPassword(String email, String encrypted);

    Login findByEmailAndIsDeleted(String username, int zero);

    Login findByPassword(String encriptedPassword);

    Login findByIdAndPassword(Integer id, String encriptedPassword);

}
