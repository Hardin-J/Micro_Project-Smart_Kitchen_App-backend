package com.mrj.ska.service;

import java.util.List;

import com.mrj.ska.model.Notification;

public interface NotificationService {

	public String removeNotification(int id);

	public List<Notification> getAllNotificationsForSingleUserId(int id);

}
