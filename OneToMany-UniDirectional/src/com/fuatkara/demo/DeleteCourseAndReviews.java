package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;

public class DeleteCourseAndReviews {

	public static void main(String args[]) {
		
		//Start SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();
			
			//int 10
			int theId = 30;
			
			//Call Course
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("TempCourse" + tempCourse);
			
			System.out.println("TempCourse GetReviews " + tempCourse.getReviews());
			//Delete course
			session.delete(tempCourse);
			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
			session.close();
			factory.close();
			System.out.println("YAnlis");
		}
	}
	
}