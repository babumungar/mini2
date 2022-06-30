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

import com.stg.model.Admin;

import com.stg.service.AdminInterface;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminInterface adminInterface;

	@PostMapping(value = "create")
	public Admin createAdmin(@RequestBody Admin admin) {
		return this.adminInterface.create(admin);
	}

	@GetMapping(value = "readalladmins")
	public List<Admin> readAllAdmins() {
		return this.adminInterface.findAllAdmins();
	}

	@GetMapping(value = "readabyid/{a}")
	public Admin readById(@PathVariable("a") int id) {
		return this.adminInterface.readById(id);
	}

	@GetMapping(value = "readabyname/{a}")
	public Admin readByName(@PathVariable("a") String name) {
		return this.adminInterface.readByName(name);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public String deleteById(@PathVariable("a") int id) {
		this.adminInterface.deleteById(id);
		return "success";
	}

}
