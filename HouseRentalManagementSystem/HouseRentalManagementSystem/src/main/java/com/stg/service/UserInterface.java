package com.stg.service;

import java.util.List;

import com.stg.model.User;

public interface UserInterface {
	public abstract User create(User admin);

	public abstract List<User> findAllUsers();

	public abstract User readById(int id);

	public abstract User readByName(String name);

	public abstract String deleteById(int id);

}
