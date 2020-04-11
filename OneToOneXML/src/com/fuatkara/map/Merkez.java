package com.fuatkara.map;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuatkara.util.HibernateUtil;

public class Merkez {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();  //Acilan Session
		Transaction transaction = null; 
		
		try {
			transaction = session.beginTransaction();
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setAdres("GemilerCek");
			studentInfo.setMail("kara.com");
			
			Student student = new Student();
			student.setStudentName("Furkan");
			student.setStudentSurname("Kara");
			student.setStudentInfo(studentInfo);

			session.save(student);	
			System.out.println("Student Saved");			
			
			transaction.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			//printStackTrace => Butun herseyi ekrana basar.
		}finally {
			//Finallerin amaci calisan Session kapatilir. 
			session.close();
		}
	}
}


