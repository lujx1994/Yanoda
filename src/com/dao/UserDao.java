package com.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.util.List;

import com.entity.Tuser;
import com.entity.Form;
import com.hibernate.util.HibernateUtil;

public class UserDao {
	
	public String saveUser(Tuser user ){
		Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return "success";
	}
	
	public String changeUserPassword(String password, String username){
		try {
			Session session = HibernateUtil.getHibernateSession();
			session.beginTransaction();
			String Sql = "update Tuser set user_password='"+password+"' where user_name='"+username+"'";
			Query query = session.createQuery(Sql);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			
		}
		return "success";
	}
	public static Tuser getUser(String name) {
		Tuser user = null;
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
			session.beginTransaction();
			user = (Tuser)session.createCriteria(Tuser.class).add(Restrictions.eq("user_name", name)).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			
		}
		return user;
	}
	public void updateUser(Tuser user){
		Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	public static void deleteForm(Form form){
		Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		session.delete(form);
		session.getTransaction().commit();
		}
	
	public static void deleteUser(Tuser user){
		Session session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		}
	
	public static Tuser findByUserId(int id){
		Tuser user = null;
		Session session = null;
		try {
		session = HibernateUtil.getHibernateSession();
		session.beginTransaction();
		user = (Tuser)session.createCriteria(Tuser.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		} catch (Exception e) {
		}
		return user;
		}

	
	@SuppressWarnings("rawtypes")
	public List getAllUser() {
	Session session = HibernateUtil.getHibernateSession();
	session.beginTransaction();
	Query query = session.createQuery("from Tuser");
	List list = query.list();
	return list;
	}
	@SuppressWarnings("rawtypes")
	public List getAllForm() {
	Session session = HibernateUtil.getHibernateSession();
	session.beginTransaction();
	Query query = session.createQuery("from Form");
	List list = query.list();
	return list;
	}

}
