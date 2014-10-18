package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Form {
	private int id;
	private String form_name;
	private String form_date;
	private String form_realpath;
	private String poster_name;
	private Boolean confirm;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
