package com.dao;


import org.hibernate.Session;

import com.entity.Form;
import com.hibernate.util.HibernateUtil;

public class FormDao {
	public String saveForm(Form form ){
		Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
		session.save(form);
		session.getTransaction().commit();
		return "success";
	}
	public static Form getForm(String poster_name,String date) {
		Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
		String Sql = "select * from Form where poster_name = '"+poster_name+"' And form_date = '"+date+"'";
		Form form = (Form)session.createSQLQuery(Sql).addEntity(Form.class).uniqueResult();
		session.getTransaction().commit();
		return form;
	}
}
