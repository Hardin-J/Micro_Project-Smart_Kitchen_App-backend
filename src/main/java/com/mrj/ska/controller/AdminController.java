package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.Admin;
import com.mrj.ska.service.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	AdminService service;

	public AdminController(AdminService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddNewAdmin(@RequestBody Admin admin) {
		String msg = "";
		try {
			msg = service.addAdmin(admin);
		} catch (Exception e) {
			msg = "Transaction Insert failed";
		}
		return msg;
	}
	
	@GetMapping("{email}/{password}")
	public Admin doLoginAdmin(@PathVariable("email") String email, @PathVariable("password") String password ) {
		Admin admin;
		admin = service.doLogin(email, password);
		if(admin != null) {
			return admin;
		} else {
			return null;
		}
	}
	
	@GetMapping("/all")
	public List<Admin> doFindAllAdmins(){
		return service.getAllAdmins();
	}
	

}
