package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.stg.model.House;
import com.stg.repository.HouseRepository;

public class HouseInterfaceImpl implements HouseInterface {

	@Autowired
	private HouseRepository houseRepository;

	@Override
	public House create(House house) {

		return houseRepository.save(house);
	}

	@Override
	public List<House> findAllHouses() {

		return houseRepository.findAllHouses();
	}

	@Override
	public House readById(int id) {

		return houseRepository.readById(id);
	}

	@Override
	public House readByName(String name) {

		return houseRepository.readByName(name);
	}

	@Override
	public String deleteById(int id) {

		houseRepository.deleteById(id);
		return "Success";
	}

}
