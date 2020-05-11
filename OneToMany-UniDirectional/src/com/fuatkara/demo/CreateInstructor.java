package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		
		//Create SessionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = 
					new Instructor("Laz", "Ziya", "lazZiya@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("www.youtube.com//lazZiya", "Adam Oldurmek");
//			
//			Course tempCourse = 
//					new Course("Baronlar Uyesi");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save the instructor
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

 