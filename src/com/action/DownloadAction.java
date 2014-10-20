package com.action;

import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.service.SimpleDate;

public class DownloadAction {
	private String path;
	private String username;
	private String loweruser;
	private String simpledate;
	private String filename;
	public java.io.InputStream getDownloadFile() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		username = (String) session.getAttribute("username");
		Tuser user = new Tuser();
		user = UserDao.getUser(username);
		loweruser = user.getLower_users();
		Date date = new Date();
		simpledate = SimpleDate.getSimpleDate(date);
		Form form = new Form(); 
		form = FormDao.getForm(loweruser, simpledate);
		path = form.getForm_realpath();
		filename = form.getForm_name();
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(path+filename);
		return in;
	}
	public String execute() throws Exception{
		return "success";
	}
}
