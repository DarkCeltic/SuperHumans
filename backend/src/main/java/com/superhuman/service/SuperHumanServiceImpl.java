package com.superhuman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhuman.dao.SuperHumanDAO;
import com.superhuman.entity.SuperHuman;

@Service
public class SuperHumanServiceImpl implements SuperHumanService {

	private SuperHumanDAO superHumanDAO;

	@Autowired
	public void setSuperHumanDAO(SuperHumanDAO superHumanDAO) {
		this.superHumanDAO = superHumanDAO;
	}

	@Override
	public void setSuperHuman(SuperHuman superHuman) {
		superHumanDAO.setSuperHuman(superHuman);
	}

	@Override
	public SuperHuman getSuperHuman(String superHumanName) {
		return superHumanDAO.getSuperHuman(superHumanName);
	}

	@Override
	public List<SuperHuman> getAllSuperHumans() {
		return superHumanDAO.getAllSuperHumans();
	}

	@Override
	public void updateSuperHuman(int id, SuperHuman superHuman) {
		superHumanDAO.updateSuperHuman(id, superHuman);
	}

	@Override
	public void deleteSuperHuman(int id) {
		superHumanDAO.deleteSuperHuman(id);
	}

}
