package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fuatkara.demo.entity.Student;

public class UpdateStudent {

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
			
			System.out.println(studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstname("Fuu");
			myStudent.setLastName("Kck");

			//commit transaction
			session.getTransaction().commit();
			
			//Update email=========================
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update all student");
			
			session.createQuery("update Student set email='gandalfcz@gmail.com' ").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}