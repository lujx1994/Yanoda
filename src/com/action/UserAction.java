package com.action;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SimpleDate;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String user_name;
	private String user_password;
	private Tuser user;
	private String message;
	private String simpledate;
	private Boolean formconfirm;
	
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
	
	
	public String login(){
		Tuser user = new Tuser();
		user = UserDao.getUser(user_name);
		if(null == user||!user_password.equals(user.getUser_password())) {
			return ERROR;
		}
		else{
			Form form = new Form();
			Date date = new Date();
			simpledate = SimpleDate.getSimpleDate(date);
			form = FormDao.getForm(user_name,simpledate);
			formconfirm = form.getConfirm();
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("username", user_name);
			session.setAttribute("formconfirminSession", formconfirm);
			return SUCCESS;
		}
	}
}
