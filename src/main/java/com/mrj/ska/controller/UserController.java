package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.User;
import com.mrj.ska.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddNewUser(@RequestBody User user) {
		String msg = "";
		try {
			msg = service.addUser(user);
		} catch (Exception e) {
			msg = "Transaction Insert failed";
		}
		return msg;
	}
	
	@PutMapping
	public String doUpdateUser(@RequestBody User user) {
		String msg = "";
		try {
			msg = service.updateUser(user);
		} catch (Exception e) {
			msg = "Transaction Update failed";
		}
		return msg;
	}
	
	@PutMapping("{id}/{password}")
	public String doUpdatePassword(@PathVariable("id") int id,@PathVariable("password") String password) {
		String msg = "";
		try {
			msg = service.updatePassword(id,password);
		} catch (Exception e) {
			msg = "Transaction Update failed";
		}
		return msg;
		
	}
	
	
	
	@GetMapping("{email}/{password}")
	public User doLoginUser(@PathVariable("email") String email, @PathVariable("password") String password ) {
		User us;
		us = service.doLogin(email, password);
		if(us != null) {
			return us;
		} else {
			return null;
		}
	}
	
	
	@GetMapping("{userId}")
	public User doFetchSingleuser(@PathVariable("userId") int id) {
		User us;
		us = service.getUserById(id);
		if(us != null) {
			return us;
		} else {
			return null;
		}
	}
	
	@GetMapping("/all")
	public List<User> doFindAllUsers(){
		return service.getAllusers();
	}
	
	

}
