package com.mrj.ska.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notification_tbl")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Notification_id")
	private long notificationId;
	
	@ManyToOne
	@JoinColumn
	private Product product;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@Column(name = "Message")
	private String message;

	public Notification() {
		super();
	}

	public Notification(long notificationId, Product product, User user, String message) {
		super();
		this.notificationId = notificationId;
		this.product = product;
		this.user = user;
		this.message = message;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
