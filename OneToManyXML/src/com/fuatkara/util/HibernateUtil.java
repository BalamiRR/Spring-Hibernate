package com.fuatkara.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final SessionFactory sessionFactory = olusturSessionFactory();

	//Burdaki amacimiz yeni session olusturmak ve durmadan aynisini main.javada calistirmamak
	//Burda kendimiz olusturcaz,ve istendigi zaman hemen cagirabilicez.
	private static SessionFactory olusturSessionFactory() {
		
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		olusturSessionFactory().close();
	}
	
	
}
