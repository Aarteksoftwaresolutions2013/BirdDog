package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.birddog.model.State;

/**
 * 
 * @author Aartek
 *
 */
public interface StateRepository extends JpaRepository<State, Integer> {

}
