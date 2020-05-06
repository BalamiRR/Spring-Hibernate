package com.fuatkara.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fuatkara.demo.entity.Instructor;
import com.fuatkara.demo.entity.InstructorDetail;

public class DeleteInstructorDetail {

	public static void main(String args[]) {
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int id=7;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, id);

			//print the instructor detail
			if(tempInstructorDetail != null) {
				System.out.println("\ntempInstructorDetail : " + tempInstructorDetail);  //InstructorDetail sinifini alir
				System.out.println("\n\nthe associated instructor: " 
							+ tempInstructorDetail.getInstructor());	//Instructor sinifini ayri olarak cagirir.
				
				System.out.println("\n\nDeleting tempInstructorDetail : " + tempInstructorDetail);
				
				//break bi-directional link
				tempInstructorDetail.getInstructor().setInstructorDetail(null);
				
				//delete
				session.delete(tempInstructorDetail);
			}
			else {
				System.out.println("It is a null");
			}
			
			//commit trasanction
			session.getTransaction().commit();
			
			System.out.println("\n\nDone!");
			
		}finally {
			session.close();
			factory.close();
		}
	}
}