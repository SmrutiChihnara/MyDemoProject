package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="whusertab")
public class WhUserType {
	@Id
	@GeneratedValue(generator="whusergen")
	@GenericGenerator(name="whusergen",strategy="increment")
	@Column(name="uid")
	private Integer userId;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	private String forType;
	@Column(name="email")
	private String userEmail;
	@Column(name="contact")
	private String usercontact;
	@Column(name="idtype")
	private String idType;
	private String ifOther;
	@Column(name="idno")
	private String idNum;
	
	public WhUserType() {
		super();
	}

	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}

	public WhUserType(Integer userId, String userType, String userCode, String forType, String userEmail,
			String usercontact, String idType, String ifOther, String idNum) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userCode = userCode;
		this.forType = forType;
		this.userEmail = userEmail;
		this.usercontact = usercontact;
		this.idType = idType;
		this.ifOther = ifOther;
		this.idNum = idNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getForType() {
		return forType;
	}

	public void setForType(String forType) {
		this.forType = forType;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", forType="
				+ forType + ", userEmail=" + userEmail + ", usercontact=" + usercontact + ", idType=" + idType
				+ ", ifOther=" + ifOther + ", idNum=" + idNum + "]";
	}
	
	
	
	

}
