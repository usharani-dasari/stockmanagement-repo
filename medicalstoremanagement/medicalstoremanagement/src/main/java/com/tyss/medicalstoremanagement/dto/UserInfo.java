package com.tyss.medicalstoremanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo {
	@Column
	@Id
	@GeneratedValue
	private int uid;
	@Column
	private String name;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column
	private int phNum;
	@Column
	private String gender;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhNum() {
		return phNum;
	}
	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
