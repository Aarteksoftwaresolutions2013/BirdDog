package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.County;

/**
 * 
 * @author Aartek
 *
 */
public interface CountyRepository extends JpaRepository<County, Integer> {

    /**
     * find by country id
     * 
     * @param countryId
     * @return
     */
    List<County> findByStateId(Integer countryId);

}
