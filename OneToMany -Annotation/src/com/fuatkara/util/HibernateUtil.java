package com.fuatkara.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//private static final SessionFactory sessionFactory = createSession();
	private static final SessionFactory SESSION_FACTORY = createSession();

	private static SessionFactory createSession() {
		
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	public void shutdown() {
		createSession().close();
	}
}
