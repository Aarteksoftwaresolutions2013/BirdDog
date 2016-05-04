package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Tutorial;

/**
 * 
 * @author Aartek
 *
 */
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

}
