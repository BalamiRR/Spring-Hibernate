package com.fuatkara.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fuatkara.demo.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction	
			session.beginTransaction();
		
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
//			for(Student tempStudent : theStudents) {        Ya boyle yapicaz yada asagidaki gibi
//				System.out.println(tempStudent);			Bu for loopu secili hale getir
//			}												Refactor > Extract Method   
//														    => en asagidaki gibi method olusturur
			displayStundents(theStudents);	
			
			//query students : lastName= "Doe"
			theStudents = 
					session.createQuery("from Student s where s.lastName = 'Duck'").list();
			
			//display students
			System.out.println("\n\nStudent who has lastname of Doe ");
			displayStundents(theStudents);	
			
			//display the student who has lastName="Gandalf" or firstName = "Josh"
			theStudents = 
					session.createQuery("from Student s where s.lastName='Gandalf' OR s.firstname='Josh'").list();

			System.out.println("\n\n Lastname Gandalf and firstname Josh: ");
			displayStundents(theStudents);

			//query student where email LIKE '%gmail.com'
			theStudents = 
					session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			
			System.out.println("\n\nEmail like 'gmail.com'");
			displayStundents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStundents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {           
			System.out.println(tempStudent);			
		}
	}
}