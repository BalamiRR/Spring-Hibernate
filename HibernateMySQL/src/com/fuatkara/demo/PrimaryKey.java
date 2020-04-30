package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Student;

public class PrimaryKey {

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
					
					//create 3 student object
					System.out.println("Creating new 3 student object ..");
					Student tempStudent = new Student("John", "Brown", "johnbrown@gmail.com");

					Student tempStudent1 = new Student("Josh", "Arwen", "josharwen@gmail.com");

					Student tempStudent2 = new Student("Saruman", "Gandalf", "gandalfcz@gmail.com");
					
					//start a transaction	
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving students");
					session.save(tempStudent);
					session.save(tempStudent1);
					session.save(tempStudent2);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}


	}


