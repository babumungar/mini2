package com.stg.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Admin;
import com.stg.model.House;

import com.stg.repository.HouseRepository;

@RestController
@RequestMapping(value = "house")
public class HouseController {

	@Autowired
	private HouseRepository houseRepository;

	@PostMapping(value = "create")
	public House createHouse(@RequestBody House house) {
		return this.houseRepository.save(house);
	}

	@GetMapping(value = "readallhouses")
	public List<House> readAllHouses() {
		return this.houseRepository.findAllHouses();
	}

	@GetMapping(value = "readabyid/{a}")
	public House readById(@PathVariable("a") int id) {
		return this.houseRepository.readById(id);
	}

	@GetMapping(value = "readabyname/{a}")
	public House readByName(@PathVariable("a") String name) {
		return this.houseRepository.readByName(name);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public House deleteById(@PathVariable("a") int id) {
		return this.houseRepository.deleteById(id);
	}
}
