package com.mrj.ska.repository_implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.ska.model.Notification;
import com.mrj.ska.repository.NotificationRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class NotificationRepositoryImplementation implements NotificationRepository{

	EntityManager em;
	
	public NotificationRepositoryImplementation(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Notification not) {
		String msg = "";
		try {
			em.persist(not);
			msg = "Notification Added Successfully";
		} catch (Exception e) {
			msg = "Adding Notification Failed";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = "";
		Notification oldNot = em.find(Notification.class, id);
		if (oldNot != null) {
			try {
				em.remove(oldNot);
				msg = "Notification Deteled Successfully";
			} catch (Exception e) {
				msg = "Notification removed UnSuccessfully";
			}
		} else {
			msg = "Notification Not found";
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> findAllNotificationsByUserId(int id) {
		String hql = "select not from Notification not where user.userId = :id";
		Query query = em.createQuery(hql).setParameter("id", id);
		return query.getResultList();
	}
}
