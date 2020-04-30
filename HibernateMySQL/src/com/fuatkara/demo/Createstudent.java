package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Student;

public class Createstudent {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			//create a student object
			System.out.println("Creating new student object ..");
			Student tempStudent = new Student("John", "Brown", "johnbrown@gmail.com");
			
			//start a transaction	
			session.beginTransaction();
			
			//save the student object
			System.out.print("Saving the student");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
