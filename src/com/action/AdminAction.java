package com.action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.dao.FormDao;
import com.dao.UserDao;
import com.entity.Form;
import com.entity.Tuser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
private static final long serialVersionUID = 1L;
private String user_name;
private String user_password;
private String user_realname;
private String lower_users;
private int range;
private String form_name;
private String form_date;
private String form_realpath;
private String poster_name;
private Boolean confirm;
private String download;
private Tuser user;
private Form form;
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
public int getRange() {
return range;
}
public void setRange(int range) {
this.range = range;
}
public String getForm_name() {
return form_name;
}
public void setForm_name(String form_name) {
this.form_name = form_name;
}
public String getForm_date() {
return form_date;
}
public void setForm_date(String form_date) {
this.form_date = form_date;
}
public String getForm_realpath() {
return form_realpath;
}
public void setForm_realpath(String form_realpath) {
this.form_realpath = form_realpath;
}
public String getPoster_name() {
return poster_name;
}
public void setPoster_name(String poster_name) {
this.poster_name = poster_name;
}
public Boolean getConfirm() {
return confirm;
}
public void setConfirm(Boolean confirm) {
this.confirm = confirm;
}
public String getDownload() {
return download;
}
public void setDownload(String download) {
this.download = download;
}
public Tuser getUser() {
return user;
}
public void setUser(Tuser user) {
this.user = user;
}
public Form getForm() {
return form;
}
public void setForm(Form form) {
this.form = form;
}
//显示所有数据
@SuppressWarnings("rawtypes")
public String showAll(){
ActionContext actionContext = ActionContext.getContext();
HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
UserDao userDao = new UserDao();
List userlist = userDao.getAllUser();
List formlist = userDao.getAllForm();
request.setAttribute("alluserlist", userlist);
request.setAttribute("allformlist", formlist);
return SUCCESS;
}

public String deleteUser(){
	HttpSession session = ServletActionContext.getRequest().getSession();
	String username = (String) session.getAttribute("username");
	if (null == username || ("").equals(username.trim())) {
		return ERROR;
	}
	UserDao.deleteUser(user);
	return SUCCESS;
}

//删除Form表条目
public String deleteForm(){
HttpSession session = ServletActionContext.getRequest().getSession();
String username = (String) session.getAttribute("username");
if (null == username || ("").equals(username.trim())) {
return ERROR;
}
UserDao.deleteForm(form);
return SUCCESS;
}
//查找Tuser表ID并显示用户基本信息
public String findByUserId(){
HttpSession session = ServletActionContext.getRequest().getSession();
String username = (String) session.getAttribute("username");
if (null == username || ("").equals(username.trim())) {
return ERROR;
}
Tuser tuser = new Tuser();
tuser = UserDao.findByUserId(user.getId());
session.setAttribute("userid", user.getId());
session.setAttribute("username", tuser.getUser_name());
session.setAttribute("userpassword", tuser.getUser_password());
session.setAttribute("lowusers", tuser.getLower_users());
session.setAttribute("userrealname", tuser.getUser_realname());
session.setAttribute("range", tuser.getUser_range());
return "success";
}
//管理员修改Tuser表信息
public String adminUpdateUser(){
HttpSession session = ServletActionContext.getRequest().getSession();
String username = (String) session.getAttribute("username");
Integer userid = (Integer) session.getAttribute("userid");
if (null == username || ("").equals(username.trim())) {
return ERROR;
}
Tuser tuser = new Tuser();
tuser = UserDao.findByUserId(userid);
tuser.setUser_name(user_name);
tuser.setUser_password(user_password);
tuser.setLower_users(lower_users);
tuser.setUser_range(range);
tuser.setUser_realname(user_realname);
new UserDao().updateUser(tuser);
tuser = UserDao.findByUserId(userid);
session.setAttribute("username", tuser.getUser_name());
session.setAttribute("userpassword", tuser.getUser_password());
session.setAttribute("lowusers", tuser.getLower_users());
session.setAttribute("userrealname", tuser.getUser_realname());
session.setAttribute("range", tuser.getUser_range());
this.addFieldError("updateError", "更新用户成功!");
return "success";
}
//查找Form表ID并显示基本信息
public String findByFormId(){
HttpSession session = ServletActionContext.getRequest().getSession();
Form tform = new Form();
tform = FormDao.findByFormId(form.getId());
session.setAttribute("formid", form.getId());
session.setAttribute("postername", tform.getPoster_name());
session.setAttribute("formname", tform.getForm_name());
session.setAttribute("formrealpath", tform.getForm_realpath());
session.setAttribute("confirm", tform.getConfirm());
session.setAttribute("formdate", tform.getForm_date());
session.setAttribute("download", tform.getDownload());
return "success";
}
//管理员修改Form表信息
public String adminUpdateForm(){
HttpSession session = ServletActionContext.getRequest().getSession();
Integer formid = (Integer) session.getAttribute("formid");
Form tform = new Form();
tform = FormDao.findByFormId(formid);
tform.setPoster_name(poster_name);
tform.setForm_name(form_name);
tform.setForm_realpath(form_realpath);;
tform.setConfirm(confirm);
tform.setForm_date(form_date);
tform.setDownload(download);
new FormDao().updateForm(tform);
tform = FormDao.findByFormId(formid);
session.setAttribute("postername", tform.getPoster_name());
session.setAttribute("formname", tform.getForm_name());
session.setAttribute("formrealpath", tform.getForm_realpath());
session.setAttribute("confirm", tform.getConfirm());
session.setAttribute("formdate", tform.getForm_date());
session.setAttribute("download", tform.getDownload());
this.addFieldError("updateError", "更新文件表成功!");
return "success";
}
}