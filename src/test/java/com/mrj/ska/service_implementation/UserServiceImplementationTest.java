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

	int num = 1; 
	@Test
	void testUpdateUser() {
		num++;
		User user = service.getUserById(20);
		user.setName("User");
		user.setEmail("user"+num+"@gmail.com");
		user.setPassword("12345678");
		user.setPhoneNumber("9638527410");
		String msg = service.updateUser(user);
		assertEquals("User Updated Successfully", msg);
	}

	@Test
	void testUpdatePassword() {
		String msg = service.updatePassword(20, "pass");
		assertEquals("User Password Updated successfully", msg);
	}

	@Test
	void testGetUserById() {
		assertNotNull(service.getUserById(20));
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
