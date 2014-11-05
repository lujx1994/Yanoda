package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Tuser {
	
	private int id;
	private String user_name;
	private String user_password;
	private String user_realname;
	private String lower_users;
	private int user_range;
	private String moblie;
	private String higer_users;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getLower_users() {
		return lower_users;
	}
	public void setLower_users(String lower_users) {
		this.lower_users = lower_users;
	}
	public int getUser_range() {
		return user_range;
	}
	public void setUser_range(int range) {
		this.user_range = range;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public String getHiger_users() {
		return higer_users;
	}
	public void setHiger_users(String higer_users) {
		this.higer_users = higer_users;
	}
	
}

