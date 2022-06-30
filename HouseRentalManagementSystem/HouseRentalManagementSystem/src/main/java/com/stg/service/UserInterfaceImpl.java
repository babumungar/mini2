package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stg.model.User;

import com.stg.repository.UserRepository;

public class UserInterfaceImpl implements UserInterface {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	@Override
	public User readById(int id) {
		return userRepository.readById(id);
	}

	@Override
	public User readByName(String name) {
		return userRepository.readByName(name);
	}

	@Override
	public String deleteById(int id) {
		userRepository.deleteById(id);
		return "Success";
	}
}
