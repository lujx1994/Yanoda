package com.dao;


import org.hibernate.Query;
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
	public static Form getFormByFormName(String form_name) {
		Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
		String Sql = "select * from Form where form_name = '"+form_name+"'";
		Form form = (Form)session.createSQLQuery(Sql).addEntity(Form.class).uniqueResult();
		session.getTransaction().commit();
		return form;
	}
	
	public void updateForm(Form form){
		try {
			Session session = HibernateUtil.getHibernateSession();
			session.beginTransaction();
			session.update(form);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateFormConfirm(String form_name){
		try{
			Session session = HibernateUtil.getHibernateSession();
			session.beginTransaction();
			String Sql = "update Form set confirm = True where form_name = '"+form_name+"'";
			Query query = session.createQuery(Sql);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}
	}
}
