package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.Admin;
import com.mrj.ska.repository.AdminRepository;
import com.mrj.ska.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService{
	
	AdminRepository repo;
	
	public AdminServiceImplementation(AdminRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addAdmin(Admin admin) {
		return repo.save(admin);
	}

	@Override
	public String updateAdmin(Admin admin) {
		return repo.update(admin);
	}

	@Override
	public String removeAdmin(int id) {
		return repo.delete(id);
	}

	@Override
	public Admin getAdminById(int id) {
		return repo.findAdminById(id);
	}

	@Override
	public Admin getAdminByEmail(String email) {
		return repo.findAdminByEmail(email);
	}

	@Override
	public Admin doLogin(String email, String password) {
		return repo.login(email, password);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return repo.findAllAdmins();
	}

}
