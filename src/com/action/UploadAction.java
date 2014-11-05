package com.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SMS;

public class UploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;
	private String uploadFilePath;
	private static String uploadFileDate;
	private String uploadFilePerson;
	private String download;
	private String username;
	
	public String getUploadFilePath() {
		return uploadFilePath;
	}
	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		username = (String) session.getAttribute("username");
		if (null == username || ("").equals(username.trim())) {
			return ERROR;
		}
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		uploadFileDate = simpleDateFormat.format(date);
		uploadFilePath = "c:\\uploadday\\";
		download = "c:\\uploadday\\" + uploadFileFileName;
		Form form = new Form();
		File checkFile = new File(uploadFilePath+uploadFileFileName);
		if (uploadFile == null){
			return ERROR;
		}
		else if (checkFile.exists()){
			checkFile.delete();
			File savedFile = new File(uploadFilePath,uploadFileFileName);
			uploadFile.renameTo(savedFile);
			new FormDao().updateFormConfirm(uploadFileFileName);
			this.addFieldError("uploadError", "操作成功");
			return SUCCESS;
		}
		else{
			uploadFilePerson = (String) session.getAttribute("username");
			System.out.println(uploadFilePerson);
			File savedFile = new File(uploadFilePath,uploadFileFileName);
			uploadFile.renameTo(savedFile);
			form.setForm_date(uploadFileDate);
			form.setForm_name(uploadFileFileName);
			form.setForm_realpath(uploadFilePath);
			form.setPoster_name(uploadFilePerson);
			form.setConfirm(null);
			form.setDownload(download);
			new FormDao().saveForm(form);
			Tuser smsUser = UserDao.getUser(username);
			String higer_users = smsUser.getHiger_users();
			Tuser smsHigh = UserDao.getUser(higer_users);
			String moblieSMS = smsHigh.getMoblie();
			try {
				SMS.send("您下属的报表已提交，请及时审阅。", moblieSMS);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.addFieldError("uploadError", "操作成功");
			return SUCCESS;
		}
	}
	
}
