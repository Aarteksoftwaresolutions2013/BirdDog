package com.birddog.service;

import java.util.List;

import com.birddog.model.County;

public interface CountyService {

    public List<County> findCountyByStateId(Integer countryId);

}
