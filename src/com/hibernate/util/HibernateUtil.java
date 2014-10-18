package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
		public static Session getHibernateSession() {
			Session session= new AnnotationConfiguration().configure().buildSessionFactory().getCurrentSession();
			return session;
		}
}
