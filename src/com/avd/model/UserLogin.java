package com.avd.model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
public class UserLogin implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="login_id")
	private int loginId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="email_id")
	private String emailId;

	private String flag;

	@Column(name="is_active")
	private String isActive;

	@Column(name="user_name")
	private String userName;

	private String password;

	@Column(name="valid_code")
	private String validCode;

	public UserLogin() {
	}

	public int getLoginId() {
		return this.loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidCode() {
		return this.validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

}