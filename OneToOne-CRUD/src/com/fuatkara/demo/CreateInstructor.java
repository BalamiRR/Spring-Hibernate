package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		
		//Create SessionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create objects
			Instructor tempInstructor = 
						new Instructor("Jacek", "Jarek", "jacekJarek@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
						new InstructorDetail("www.youtube.com//Jarek", "Footbal");

			//set an object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start transaction
			session.beginTransaction();
						
			//save the instructor
			System.out.println("Saving instructor : " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}

}

 