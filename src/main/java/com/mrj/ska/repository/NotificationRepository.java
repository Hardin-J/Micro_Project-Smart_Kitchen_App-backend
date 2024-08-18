package com.mrj.ska.repository;

import java.util.List;

import com.mrj.ska.model.Notification;

public interface NotificationRepository {

	public String save(Notification not);

	public String delete(int id);

	public List<Notification> findAllNotificationsByUserId(int id);

}
