package com.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.entity.Tuser;
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

}
