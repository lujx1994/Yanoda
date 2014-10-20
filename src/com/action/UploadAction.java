package com.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FormDao;
import com.entity.Form;
import com.opensymphony.xwork2.ActionSupport;

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
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		uploadFileDate = simpleDateFormat.format(date);
		Form form = new Form();
		if (uploadFile == null){
			return ERROR;
		}
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			uploadFilePerson = (String) session.getAttribute("username");
			uploadFilePath = "c:\\uploadday\\";
			File savedFile = new File(uploadFilePath,uploadFileFileName);
			uploadFile.renameTo(savedFile);
			form.setForm_date(uploadFileDate);
			form.setForm_name(uploadFileFileName);
			form.setForm_realpath(uploadFilePath);
			form.setPoster_name(uploadFilePerson);
			form.setConfirm(null);
			new FormDao().saveForm(form);
			return SUCCESS;
		}
	}
	
}
