package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;

public class CreateCourse {

	public static void main(String args[]) {
		
		//Start SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.getTransaction();

			//begin transaction
			session.beginTransaction();
			
			//get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//create some courses
			Course tempCourse1 = new Course("Raconluk");
			Course tempCourse2 = new Course("Adam Oldurme");
			
			//set courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			//save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
			
		}
	}
	
}