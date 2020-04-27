package com.fuatkara.map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuatkara.util.HibernateUtil;

public class ApplicationMain {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();  //Acilan Session
		Transaction transaction = null; 
		
		try {
			transaction = session.beginTransaction();
			
			Department department = new Department();
			department.setDepartmentName("Building-B");
			session.save(department);
			
			Employee employee1 = new Employee("Adam","Muchobor");
			Employee employee2 = new Employee("Wojciech","Gupta");
			Employee employee3 = new Employee("Piotr","Poster");

			employee1.setDepartment(department);
			employee2.setDepartment(department);
			employee3.setDepartment(department);

			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			System.out.println("Employees are Saved");			
			
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


