package com.superhuman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.superhuman.entity.SuperHuman;
import com.superhuman.service.SuperHumanService;

@Controller
public class SuperHumanController {

	private SuperHumanService superHumanService;

	@Autowired
	public void setSuperHumanService(SuperHumanService superHumanService) {
		this.superHumanService = superHumanService;
	}

	// get a single superhuman
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/super-human/{name}")
	@ResponseBody
	public SuperHuman getCar(@PathVariable String name) {
		return superHumanService.getSuperHuman(name);
	}

	// get all superHumans
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/super-human")
	@ResponseBody
	public List<SuperHuman> getAllSuperHumans() {
		return superHumanService.getAllSuperHumans();
	}

	// Save superhuman
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/super-human", consumes = "application/json")
	public ResponseEntity<?> setSuperHuman(@RequestBody SuperHuman superHuman) {
		try {
			superHumanService.setSuperHuman(superHuman);
			ResponseEntity.status(HttpStatus.CREATED);
			return ResponseEntity.ok().body(superHuman.getName() + " has been created");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}

	// delete superhuman
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/super-human/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteSuperHero(@PathVariable int id) {
		superHumanService.deleteSuperHuman(id);
		return ResponseEntity.ok().body("SuperHero has been deleted");
	}

	// update superhuman
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path = "/super-human/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteSuperHero(@PathVariable int id, @RequestBody SuperHuman superHuman) {
		superHumanService.updateSuperHuman(id, superHuman);
		return ResponseEntity.ok().body(superHuman.getName() + " has been updated");
	}
}
