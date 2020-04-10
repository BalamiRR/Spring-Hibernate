package com.fuatkara.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fuatkara.util.HibernateUtil;

public class Merkez {
	public static void main(String[] args) {

		Session session = HibernateUtil().getSessionFactory().openSession();
		Transaction transaction=null; 
		
		try {
			transaction = session.beginTransaction();
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setAdres("Gemiler Cek.");
			studentInfo.setMail("kara.com");
			
			
			Student student = new Student("Balamir","Donnez");
			//student.setStudentName("Fuat");
			//student.setStudentSurname("Kara");
			student.setStudentInfo(studentInfo);

			session.save(student);
			
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}


}



