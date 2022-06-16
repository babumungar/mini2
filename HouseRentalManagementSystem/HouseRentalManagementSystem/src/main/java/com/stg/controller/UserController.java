package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.House;
import com.stg.model.User;
import com.stg.repository.UserRepository;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "create")
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	@GetMapping(value = "readallusers")
	public List<User> readAllHouses() {
		return this.userRepository.findAllUsers();
	}

	@GetMapping(value = "readabyid/{a}")
	public User readById(@PathVariable("a") int id) {
		return this.userRepository.readById(id);
	}

	@GetMapping(value = "readabyname/{a}")
	public User readByName(@PathVariable("a") String name) {
		return this.userRepository.readByName(name);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public User deleteById(@PathVariable("a") int id) {
		return this.userRepository.deleteById(id);
	}
}
