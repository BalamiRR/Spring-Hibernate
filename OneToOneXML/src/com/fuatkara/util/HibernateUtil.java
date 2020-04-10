package com.fuatkara.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final SessionFactory sessionFactory = createMethod();

	//Burdaki amacimiz yeni session olusturmak,ve durmadan aynisini main.javada calistirmamak
	//Burda kendimiz olusturcaz,ve istendigi zaman hemen cagirabilicez.
	private static SessionFactory createMethod() {
		
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch (Exception e) {
			return null;
		}
	
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		createMethod().close();
	}
	
	
}




