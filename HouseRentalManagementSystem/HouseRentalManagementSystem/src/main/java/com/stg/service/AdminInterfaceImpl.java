
package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.model.Admin;
import com.stg.repository.AdminRepository;

@Service
public class AdminInterfaceImpl implements AdminInterface {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin create(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> findAllAdmins() {

		return adminRepository.findAllAdmins();
	}

	@Override
	public Admin readById(int id) {

		return adminRepository.readById(id);
	}

	@Override
	public Admin readByName(String name) {

		return adminRepository.readByName(name);
	}

	@Override
	public String deleteById(int id) {
		adminRepository.deleteById(id);
		return "Success";
	}

}
