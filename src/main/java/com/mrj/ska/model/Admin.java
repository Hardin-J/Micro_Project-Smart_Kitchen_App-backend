package com.mrj.ska.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin_tbl")
public class Admin {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Admin_Id")
	private long adminId;
	
	@Column(name = "Admin_Name")
	private String adminName;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	@Column(name = "Password")
	private String password;

	public Admin() {
		super();
	}

	public Admin(long adminId, String adminName, String emailId, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.emailId = emailId;
		this.password = password;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
