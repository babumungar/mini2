package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Admin;
import com.stg.repository.AdminRepository;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping(value = "create")
	public Admin createAdmin(@RequestBody Admin admin) {
		return this.adminRepository.save(admin);
	}

	@GetMapping(value = "readalladmins")
	public List<Admin> readAllAdmins() {
		return this.adminRepository.findAllAdmins();
	}

	@GetMapping(value = "readabyid/{a}")
	public Admin readById(@PathVariable("a") int id) {
		return this.adminRepository.readById(id);
	}

	@GetMapping(value = "readabyname/{a}")
	public Admin readByName(@PathVariable("a") String name) {
		return this.adminRepository.readByName(name);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public Admin deleteById(@PathVariable("a") int id) {
		return this.adminRepository.deleteById(id);
	}

}
