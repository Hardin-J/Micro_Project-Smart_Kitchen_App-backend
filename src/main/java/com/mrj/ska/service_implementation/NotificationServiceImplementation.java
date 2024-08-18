package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.Notification;
import com.mrj.ska.repository.NotificationRepository;
import com.mrj.ska.service.NotificationService;

@Service
public class NotificationServiceImplementation implements NotificationService{

	NotificationRepository repo;
	
	public NotificationServiceImplementation(NotificationRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String removeNotification(int id) {
		return repo.delete(id);
	}

	@Override
	public List<Notification> getAllNotificationsForSingleUserId(int id) {
		return repo.findAllNotificationsByUserId(id);
	}

}
