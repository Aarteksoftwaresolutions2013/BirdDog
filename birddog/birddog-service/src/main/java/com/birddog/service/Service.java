package com.birddog.service;

import java.util.List;

/**
 * @author Aartek, Defines methods common to service classes.
 */
public interface Service<T> {

	/**
	 * Saves the object, creates new record in the database.
	 * @return 
	 */
	void save(T object);

	/**
	 * Get all the details of the given entity.
	 */
	List<T> getAll();

	/**
	 * Updates record.
	 */
	T update(int id);

	/**
	 * Deletes record.
	 */
	void delete(int id);

}
