package com.mrj.ska.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Purchase_History_tbl")
public class PurchaseHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Purchase_History_id")
	private long purchaseHistoryId;

	@ManyToOne
	@JoinColumn
	private Product product;

	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
	@JoinColumn
	private User user;
	
	@Column(name = "product_quantity")
	private int quantity;

	public PurchaseHistory() {
		super();
	}

	public PurchaseHistory(long purchaseHistoryId, Product product, User user, int quantity) {
		super();
		this.purchaseHistoryId = purchaseHistoryId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}

	public long getPurchaseHistoryId() {
		return purchaseHistoryId;
	}

	public void setPurchaseHistoryId(long purchaseHistoryId) {
		this.purchaseHistoryId = purchaseHistoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
