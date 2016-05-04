package com.birddog.service;

import java.util.List;

import com.birddog.model.City;

public interface CityService {

	public List<City> getAllCity();

	public City getCity(Integer id);

	public List<City> findCityByCountyId(Integer id);

}
