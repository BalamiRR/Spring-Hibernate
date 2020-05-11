package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;

public class CreateCourseAndReviews {

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
			
			//Add course
			Course tempCourse = new Course("Basketbolcu - How you think");
			
			//Add Review
			Review tempReview = new Review("Kotu oynuyor");
			tempCourse.addReview(tempReview);
			
			Review tempReview1 = new Review("Iyi oynuyor");
			tempCourse.addReview(tempReview1);
			
			//tempCourse.addReview(new Review("Kotu actorluk yapiyor"));      We could also write in this way
			
			//save the course
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
			
		}
	}
	
}