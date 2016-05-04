package com.birddog.service;

import java.util.List;

import com.birddog.model.State;

/**
 * 
 * @author Aartek
 *
 */
public interface StateService {

    /**
     * find all country name
     * 
     * @return Countries
     */
    public List<State> getAllStates();

}
