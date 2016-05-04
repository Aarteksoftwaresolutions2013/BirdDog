package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.City;
import com.birddog.repository.CityRepository;
import com.birddog.service.CityService;

/**
 * 
 * @author Aartek
 *
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

	public List<City> getAllCity() {
		return cityRepository.findAll();
	}

	public City getCity(Integer id) {
		return cityRepository.findById(id);
	}

	public  List<City> findCityByCountyId(Integer id) {
		return cityRepository.findByCountyId(id);
	}
}
