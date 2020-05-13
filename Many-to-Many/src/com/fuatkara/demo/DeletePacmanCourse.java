package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Course;
import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;
import com.fuatkara.demo.entity.Review;
import com.fuatkara.demo.entity.Student;

public class DeletePacmanCourse {

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

			//get the pacman course from db
//			int courseId = 10;
			session.createQuery("delete from Course where id=21").executeUpdate();
			
			//delete the course  
			
//			if(tempCourse != null) {				
//				System.out.println("Deleting course => ");
//				session.delete(tempCourse);
//			}
//			else {
//				System.out.println("Not Working Fuat!");
//			}
//			
			//Transaction commit 
			session.getTransaction().commit();
			
			System.out.println("DONE !! ");
			
		}finally {
			session.close();
		}
	}
	
}