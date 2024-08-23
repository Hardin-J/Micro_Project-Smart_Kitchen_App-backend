package com.mrj.ska.service_implementation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mrj.ska.service.NotificationService;

@SpringBootTest
class NotificationServiceImplementationTest {

	@Autowired
	NotificationService service;
	
	@Test
	void testGetAllNotificationsForSingleUserId() {
		assertNotNull(service.getAllNotificationsForSingleUserId(1));
	}

}
