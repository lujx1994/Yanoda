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
	private String lower_users;
	private String user_realname;
	private Tuser user;
	private String message;
	private String simpledate;
	private int range;
	private Boolean formconfirm;
	private String olduser_password;
	
	public String getOlduser_password() {
		return olduser_password;
	}
	public void setOlduser_password(String olduser_password) {
		this.olduser_password = olduser_password;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getLower_users() {
		return lower_users;
	}
	public void setLower_users(String lower_users) {
		this.lower_users = lower_users;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
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
	
	
	public String login(){
		Tuser user = new Tuser();
		user = UserDao.getUser(user_name);
		if(null == user||!user_password.equals(user.getUser_password())) {
			this.addFieldError("loginError", "用户名或密码错误");
			return ERROR;
		}
		else{
			lower_users = user.getLower_users();
			user_realname = user.getUser_realname();
			range = user.getRange();
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("lowusers", lower_users);
			session.setAttribute("username", user_name);
			session.setAttribute("userrealname", user_realname);
			session.setAttribute("range", range);
			return SUCCESS;
		}
	}
	
	public String showMessage(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		if (null == username || ("").equals(username.trim())) {
			return ERROR;
		}
		Form form = new Form();
		Date date = new Date();
		simpledate = SimpleDate.getSimpleDate(date);
		form = FormDao.getForm(username,simpledate);
		if (form==null){
			message = "请及时上传复命表";
			session.setAttribute("message", message);
			return SUCCESS;
		}
		else{
			formconfirm = form.getConfirm();
			if (formconfirm==null){
				message = "复命表待审中";
				session.setAttribute("message", message);
				return SUCCESS;
			}
			else{
				message = "复命表已被上级审阅";
				session.setAttribute("message", message);
				return SUCCESS;
			}
		}
	}
	
	public String changePassword(){		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		if (null == username || ("").equals(username.trim())) {
			return ERROR;
		}
		Tuser user = new Tuser();
		user = UserDao.getUser(username);
		String password = user.getUser_password();
		if (password.equals(olduser_password)){
			new UserDao().changeUserPassword(user_password,username);
		}
		else{
			this.addFieldError("confirmPasswordError", "原始密码输入错误！");
			return "fail";
		}
		this.addFieldError("confirmPasswordError", "修改密码成功！");
		return SUCCESS;
	}
	
	public String addUser(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		if (null == username || ("").equals(username.trim())) {
			return ERROR;
		}	
		int rangenow = (int) session.getAttribute("range");
		if (rangenow==4){
			Tuser user = new Tuser();
			user.setUser_name(user_name);
			user.setUser_password(user_password);
			user.setUser_realname(user_realname);
			if (null == user.getLower_users() || ("").equals(user.getLower_users().trim())){
				user.setLower_users(null);
			}
			else{
				user.setLower_users(lower_users);
			}
			user.setRange(range);
			new UserDao().saveUser(user);
		}
		else{
			this.addFieldError("addUserError", "你没有添加用户的权限！");
			return "fail";
		}
		this.addFieldError("addUserError", "添加成功！");
		return SUCCESS;
	}
	
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("lowusers", null);
		session.setAttribute("username", null);
		session.setAttribute("userrealname", null);
		session.setAttribute("range", null);
		return "success";
	}
}
