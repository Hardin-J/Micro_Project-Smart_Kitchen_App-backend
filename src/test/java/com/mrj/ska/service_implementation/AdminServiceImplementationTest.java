package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.model.Admin;
import com.mrj.ska.service.AdminService;

@SpringBootTest
class AdminServiceImplementationTest {

	@Autowired
	AdminService service;
	static int cnt = 1;
	
	@Test
	void testSaveSuccess() {
		Admin admin = new Admin();
		admin.setAdminName("Admin");
		admin.setEmailId("admin"+cnt+"@gmail.com");
		admin.setPassword("12345");
		String msg = service.addAdmin(admin);
		assertEquals("Admin Added Successfully", msg);
		cnt++;
	}

	@Test
	void testUpdate() {
		Admin admin = service.getAdminById(22);
		admin.setAdminName("NewAdmin");
		admin.setPassword("54321");
		String msg = service.updateAdmin(admin);
		assertEquals("Admin Updated Successfully", msg);
	}

	@Test
	void testFindAdminById() {
		Admin admin = service.getAdminById(1);
		assertNotNull(admin);
	}

	@Test
	void testFindAdminByEmail() {
		Admin admin = service.getAdminByEmail("mrjeeva1011@gmail.com");
		assertNotNull(admin);		
	}

	@Test
	void testLogin() {
		Admin admin = service.doLogin("mrjeeva1011@gmail.com", "Jeeva@10");
		assertNotNull(admin);
	}

	@Test
	void testFindAllAdmins() {
		assertNotNull(service.getAllAdmins());
	}

}
