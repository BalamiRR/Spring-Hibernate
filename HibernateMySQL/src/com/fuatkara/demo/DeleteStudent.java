package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fuatkara.demo.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//start transaction			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId); 

			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);

			//delete stundet id=2 ====================
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}