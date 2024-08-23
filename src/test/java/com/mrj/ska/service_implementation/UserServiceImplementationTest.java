package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.model.User;
import com.mrj.ska.service.UserService;

@SpringBootTest
class UserServiceImplementationTest {
	
	@Autowired
	UserService service;

	@Test
	void testAddUser() {
		User user = new User();
		String msg = service.addUser(user);
		assertEquals("User Added Successfully", msg);
	}

	@Test
	void testUpdateUser() {
		User user = service.getUserById(9);
		String msg = service.updateUser(user);
		assertEquals("User Updated Successfully", msg);
	}

	@Test
	void testUpdatePassword() {
		String msg = service.updatePassword(9, "pass");
		assertEquals("User Password Updated successfully", msg);
	}

	@Test
	void testGetUserById() {
		assertNotNull(service.getUserById(9));
	}

	@Test
	void testGetUserByName() {
		assertNotNull(service.getUserByName("Jeeva"));
	}

	@Test
	void testDoLogin() {
		User user = service.doLogin("senorjeeva@gmail.com", "ChangeP455w0rd");
		assertNotNull(user);
	}

	@Test
	void testGetAllusers() {
		assertNotNull(service.getAllusers());
	}

}
