package com.mrj.ska.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrj.ska.model.Notification;
import com.mrj.ska.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@CrossOrigin("http://localhost:3000")
public class NotificationController {
	
	NotificationService service;

	public NotificationController(NotificationService service) {
		super();
		this.service = service;
	}
	
	@DeleteMapping("{notId}")
	public String doDeleteSingleNotification(@PathVariable("notId") int notId) {
		String msg = "";
		try {
			msg = service.removeNotification(notId);
		} catch (Exception e) {
			msg = "Transaction removal failed";
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public List<Notification> doFindAllUsers(@PathVariable("id") int id){
		return service.getAllNotificationsForSingleUserId(id);
	}
	
}
