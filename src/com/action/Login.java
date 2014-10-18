package com.action;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.entity.Tuser;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String user_name;
	private String user_password;
	private Tuser user;
	private String message;
	public String excute(){
		
		Tuser user = null;
		user = UserDao.getUser(user_name);
		if(null == user||!user_password.equals(user.getUser_password())) {
			return ERROR;
		}
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		session.setAttribute("username", user_name);
		session.setAttribute("userIdInSession", user.getId());
		
		return SUCCESS;
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
	public Tuser getUser() {
		return user;
	}
	public void setUser(Tuser user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
