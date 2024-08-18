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
	
	@Column(name = "Status")
	private String status;

	public Notification() {
		super();
	}

	public Notification(long notificationId, Product product, String message, String status) {
		super();
		this.notificationId = notificationId;
		this.product = product;
		this.message = message;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
