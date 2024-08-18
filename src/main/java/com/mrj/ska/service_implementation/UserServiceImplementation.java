package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.User;
import com.mrj.ska.repository.UserRepository;
import com.mrj.ska.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	UserRepository repo;

	public UserServiceImplementation(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addUser(User user) {
		return repo.save(user);
	}

	@Override
	public String updateUser(User user) {
		return repo.update(user);
	}

	@Override
	public String removeUser(int id) {
		return repo.delete(id);
	}

	@Override
	public String updatePassword(int id, String password) {
		return repo.updatePassword(id, password);
	}

	@Override
	public User getUserById(int id) {
		return repo.findUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return repo.findUserByName(name);
	}

	public User doLogin(String email, String password) {
		return repo.login(email, password);
	}

	@Override
	public List<User> getAllusers() {
		return repo.findAllUsers();
	}
}
