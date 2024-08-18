package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.User;

public interface UserService {

	public String addUser(User user);

	public String updateUser(User user);

	public String removeUser(int id);

	public String updatePassword(int id, String password);

	public User getUserById(int id);

	public User getUserByName(String name);
	
	public User doLogin(String email, String password);
	
	public List<User> getAllusers();

}
