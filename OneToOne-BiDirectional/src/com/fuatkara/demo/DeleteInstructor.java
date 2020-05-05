package com.fuatkara.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;

public class DeleteInstructor {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//start transcation
			session.beginTransaction();
			
			int theId = 2;
			
			Instructor tempInstructor =
							session.get(Instructor.class, theId);
			
			System.out.println("Found instructor : " + tempInstructor);
			
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor);
			}
			
			else {
				System.out.println("Instructor is empty");
			}
			//get Instructor
			//session.createQuery("delete from Instructor where id=1").executeUpdate();
			
			//close session
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}
}