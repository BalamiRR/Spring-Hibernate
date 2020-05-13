package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;
import com.fuatkara.demo.entity.Student;

public class CreateCourseAndStudents {

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
			
			//Create a course
			Course tempCourse = new Course("Singer - Singer");
			
			//Save the course
			System.out.println("\nSaving the course..");
			session.save(tempCourse);
			System.out.println("Saved the course " + tempCourse);
			
			//Create the students
			Student tempStudent = new Student("Shakira", "pique", "pique@gmail.com");
			Student tempStudent1 = new Student("Feridun", "Duz", "duz@gmail.com");
			
			//add students to the course
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			
			//save the students
			System.out.println("\nSaving students...");
			session.save(tempStudent);
			session.save(tempStudent1);
			System.out.println("Saved students: " + tempCourse.getStudents());
		
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
		
		}
	}
	
}