package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.User;

public interface UserRepository {

	public String save(User user);

	public String update(User user);

	public String delete(int id);

	public String updatePassword(int id, String password);

	public User findUserById(int id);

	public User findUserByName(String name);
	
	public User login(String email, String password);
	
	public List<User> findAllUsers();

}
