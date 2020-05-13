package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;
import com.fuatkara.demo.entity.Student;

public class AddCoursesForMary {

	public static void main(String args[]) {
		
		//Start SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();

			//get the student mary from database
			int studentId = 3;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\n Loaded student : " + tempStudent);
			tempStudent.getCourses();
			
			//create more courses
			Course tempCourse = new Course("Matematik - Ali Nesin");
			Course tempCourse1 = new Course("Yazar - Aziz Nesin");
			
			//add student to courses
			tempCourse.addStudent(tempStudent);
			tempCourse1.addStudent(tempStudent);
			
			//save the courses
			session.save(tempCourse);
			session.save(tempCourse1);
			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
		
		}
	}
	
}