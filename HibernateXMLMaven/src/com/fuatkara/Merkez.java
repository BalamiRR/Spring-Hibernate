package com.fuatkara;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Merkez {
	public static void main(String[] args) {
		
		Personel personel = new Personel();
		
		personel.setPersonelName("Balamir");
		personel.setPersonelSurname("Kara");
		personel.setPersonelEmail("xf");
		
		//--------------------------------------------------
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
		
	}
}