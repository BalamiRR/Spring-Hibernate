package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;

public class GetCourseAndReviews {

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
			
			int theId = 12;
			
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("Course id : " + tempCourse);
		
			System.out.println("Course and Review : " + tempCourse.getReviews());			
			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
			System.out.println("Biseyler yanlis!!");
		}
	}
	
}