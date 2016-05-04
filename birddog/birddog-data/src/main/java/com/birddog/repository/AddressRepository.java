package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Address;

/**
 * 
 * @author Aartek
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findById(int id);

}
