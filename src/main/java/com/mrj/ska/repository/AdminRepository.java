package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.Admin;

public interface AdminRepository {

	public String save(Admin admin);

	public String update(Admin admin);

	public String delete(int id);

	public Admin findAdminById(int id);

	public Admin findAdminByEmail(String email);
	
	public Admin login(String email, String password);
	
	public List<Admin> findAllAdmins();

}
