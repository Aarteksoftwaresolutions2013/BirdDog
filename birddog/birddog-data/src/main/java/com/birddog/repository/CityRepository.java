package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.City;

/**
 * 
 * @author Aartek
 *
 */
public interface CityRepository extends JpaRepository<City, Integer> {

    City findById(Integer id);

    List<City> findByCountyId(Integer id);

}
