package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.County;
import com.birddog.repository.CountyRepository;
import com.birddog.service.CountyService;

/**
 * 
 * @author Aartek
 *
 */
@Service
public class CountyServiceImpl implements CountyService {
	
    @Autowired
    private CountyRepository stateRepository;

    /**
     * find by country id
     */
    public List<County> findCountyByStateId(Integer stateId) {
        return stateRepository.findByStateId(stateId);
    }

}
