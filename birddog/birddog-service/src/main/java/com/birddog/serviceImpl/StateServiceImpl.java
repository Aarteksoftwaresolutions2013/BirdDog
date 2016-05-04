package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.State;
import com.birddog.repository.StateRepository;
import com.birddog.service.StateService;

/**
 * 
 * @author Aartek
 *
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    /**
     * find all country
     */
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
