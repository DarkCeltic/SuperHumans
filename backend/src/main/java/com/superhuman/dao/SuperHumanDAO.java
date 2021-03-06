package com.superhuman.dao;

import java.util.List;

import com.superhuman.entity.SuperHuman;

public interface SuperHumanDAO {

	// Save a superHuman
	void setSuperHuman(SuperHuman superHuman);

	// Get a single superHuman
	SuperHuman getSuperHuman(String superHumanName);

	// Get all superHumans
	List<SuperHuman> getAllSuperHumans();

	// Update a superHuman
	void updateSuperHuman(int id, SuperHuman superHuman);
		
		//Delete a superHuman
	void deleteSuperHuman(int id);

}
