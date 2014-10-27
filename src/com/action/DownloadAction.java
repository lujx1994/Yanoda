package com.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.service.SimpleDate;

public class DownloadAction {
	private String username;
	private String simpledate;
	private ArrayList<Form> formList;
	public ArrayList<Form> getFormList() {
		return formList;
	}

	public void setFormList(ArrayList<Form> formList) {
		this.formList = formList;
	}
	
	public String showDownload(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		username = (String) session.getAttribute("username");
		if (null == username || ("").equals(username.trim())) {
			return "error";
		}
		
		int i,j;
		Date date = new Date();
		simpledate = SimpleDate.getSimpleDate(date);
		Tuser user = new Tuser();
		user = UserDao.getUser(username);
		String[] loweruserStrings = user.getLower_users().split(",");
		formList = new ArrayList<Form>();
		Form[] lform = new Form[20];
		if (user.getRange()==3){
		for (i=0;i<loweruserStrings.length;i++){
			Tuser luser = new Tuser();
			luser = UserDao.getUser(loweruserStrings[i]);
			if (luser.getRange()==1){
				Form nform = new Form();
				nform = FormDao.getForm(luser.getUser_name(), simpledate);
				if (nform!=null){
				formList.add(nform);
				}
				else{
				}
			}
			else{
			String[] lowerlowerusersStrings = luser.getLower_users().split(",");
			for (j=0;j<lowerlowerusersStrings.length;j++){
				lform[j] = FormDao.getForm(lowerlowerusersStrings[j],simpledate);
				if (lform[j]==null){
				}
				else{
					if (lform[j].getConfirm()==true){
						formList.add(lform[j]);
					} 
					else{
					}
				}
			}
			}
		}
		}
		else{
			Form[] form = new Form[loweruserStrings.length];
			for (i=0;i<loweruserStrings.length;i++){
				form[i] = FormDao.getForm(loweruserStrings[i],simpledate);
				formList.add(form[i]);
			}
		}
		return "success";
	}
}
