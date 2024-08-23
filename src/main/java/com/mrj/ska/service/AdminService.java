package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.Admin;

public interface AdminService {
	public String addAdmin(Admin admin);

	public String updateAdmin(Admin admin);

	public String removeAdmin(int id);

	public Admin getAdminById(int id);

	public Admin getAdminByEmail(String email);
	
	public Admin doLogin(String email, String password);
	
	public List<Admin> getAllAdmins();

}
